package ngrams;

import edu.princeton.cs.algs4.In;

import java.util.Collection;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * An object that provides utility methods for making queries on the
 * Google NGrams dataset (or a subset thereof).
 *
 * An NGramMap stores pertinent data from a "words file" and a "counts
 * file". It is not a map in the strict sense, but it does provide additional
 * functionality.
 *
 * @author Josh Hug
 */
public class NGramMap {

    // TODO: Add any necessary static/instance variables.
    TreeMap<String,TimeSeries> wyac = null;
    TimeSeries allcount = null;

    /**
     * Constructs an NGramMap from WORDSFILENAME and COUNTSFILENAME.
     */
    public NGramMap(String wordsFilename, String countsFilename) {
        allcount = new TimeSeries();
        wyac = new TreeMap<>();
        In in = new In(wordsFilename);
        while (in.hasNextLine()) {
            String nextline = in.readLine();
            String[] splitLine = nextline.split("\t");
            if (wyac.containsKey(splitLine[0])) {
                TimeSeries c = wyac.get(splitLine[0]);
                c.put(Integer.valueOf(splitLine[1]),(double)Integer.valueOf(splitLine[2]));
            } else {
                TimeSeries c = new TimeSeries();
                c.put(Integer.valueOf(splitLine[1]),(double)Integer.valueOf(splitLine[2]));
                wyac.put(splitLine[0],c);
            }
        }
        in = new In(countsFilename);
        while (in.hasNextLine()) {
            String nextline = in.readLine();
            String[] splitLine = nextline.split(",");
            int a;
            double b;
            a = Integer.parseInt(splitLine[0]);
            b = Double.parseDouble(splitLine[1]);
            allcount.put(a,b);
        }
        // TODO: Fill in this constructor. See the "NGramMap Tips" section of the spec for help.
    }

    /**
     * Provides the history of WORD between STARTYEAR and ENDYEAR, inclusive of both ends. The
     * returned TimeSeries should be a copy, not a link to this NGramMap's TimeSeries. In other
     * words, changes made to the object returned by this function should not also affect the
     * NGramMap. This is also known as a "defensive copy". If the word is not in the data files,
     * returns an empty TimeSeries.
     */
    public TimeSeries countHistory(String word, int startYear, int endYear) {
        // TODO: Fill in this method.
        TimeSeries now = wyac.get(word);
        TimeSeries neww = new TimeSeries(now,startYear,endYear);
        return neww;
    }

    /**
     * Provides the history of WORD. The returned TimeSeries should be a copy, not a link to this
     * NGramMap's TimeSeries. In other words, changes made to the object returned by this function
     * should not also affect the NGramMap. This is also known as a "defensive copy". If the word
     * is not in the data files, returns an empty TimeSeries.
     */
    public TimeSeries countHistory(String word) {
        // TODO: Fill in this method.
        TimeSeries now = wyac.get(word);
        TimeSeries neww = new TimeSeries(now,TimeSeries.MIN_YEAR,TimeSeries.MAX_YEAR);
        return neww;
    }

    /**
     * Returns a defensive copy of the total number of words recorded per year in all volumes.
     */
    public TimeSeries totalCountHistory() {
        // TODO: Fill in this method.
        TimeSeries neww = new TimeSeries(allcount,TimeSeries.MIN_YEAR,TimeSeries.MAX_YEAR);
        return neww;
    }

    /**
     * Provides a TimeSeries containing the relative frequency per year of WORD between STARTYEAR
     * and ENDYEAR, inclusive of both ends. If the word is not in the data files, returns an empty
     * TimeSeries.
     */
    public TimeSeries weightHistory(String word, int startYear, int endYear) {
        // TODO: Fill in this method.
        TimeSeries w = wyac.get(word);
        TimeSeries now = w.dividedBy(allcount);
        TimeSeries neww = new TimeSeries(now,startYear,endYear);
        return neww;
    }

    /**
     * Provides a TimeSeries containing the relative frequency per year of WORD compared to all
     * words recorded in that year. If the word is not in the data files, returns an empty
     * TimeSeries.
     */
    public TimeSeries weightHistory(String word) {
        // TODO: Fill in this method.
        TimeSeries w = wyac.get(word);
        TimeSeries now = w.dividedBy(allcount);
        TimeSeries neww = new TimeSeries(now,TimeSeries.MIN_YEAR,TimeSeries.MAX_YEAR);
        return neww;
    }

    /**Provides the summed relative frequency per year of all words in WORDS between STARTYEAR and
     * ENDYEAR, inclusive of both ends. If a word does not exist in this time frame, ignore it
     * rather than throwing an exception.
     *
     */
    public TimeSeries summedWeightHistory(Collection<String> words,
                                          int startYear, int endYear) {
        // TODO: Fill in this method.
        TimeSeries now = new TimeSeries();
        for (String item : words) {
            now = now.plus(wyac.get(item));
        }
        TimeSeries neww = new TimeSeries(now,startYear,endYear);
        TimeSeries newww = neww.dividedBy(allcount);
        return newww;
    }

    /**
     * Returns the summed relative frequency per year of all words in WORDS. If a word does not
     * exist in this time frame, ignore it rather than throwing an exception.
     */
    public TimeSeries summedWeightHistory(Collection<String> words) {
        // TODO: Fill in this method.
        TimeSeries now = new TimeSeries();
        for (String item : words) {
            now = now.plus(wyac.get(item));
        }
        TimeSeries noww = now.dividedBy(allcount)
        return noww;
    }

    // TODO: Add any private helper methods.
    // TODO: Remove all TODO comments before submitting.
}
