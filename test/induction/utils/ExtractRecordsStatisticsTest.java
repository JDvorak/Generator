package induction.utils;

import induction.problem.event3.generative.GenerativeEvent3Model;
import fig.exec.Execution;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author konstas
 */
public class ExtractRecordsStatisticsTest
{
    
    GenerativeEvent3Model model;
    
    public ExtractRecordsStatisticsTest()
    {
    }
    
    @Before
    public void setUp()
    {
//        double[][] ar = new double[36][36];
//        for(String line: Utils.readLines(("/home/sinantie/data")))
//        {
//            String tok[] = line.split("\t");
//            ar[Integer.valueOf(tok[0])][Integer.valueOf(tok[1])] = Double.valueOf(tok[2]);
//        }        
//        StringBuilder str = new StringBuilder();
//        for(double[] line : ar)
//        {
//            for(Double d : line)
//            {
//                str.append(d > 0.0 ? String.format("%.5f", d) : "").append("\t");
//            }
//            str.append("\n");
//        }
//        Utils.write("/home/sinantie/data.out", str.toString());
//        System.exit(0);
        
//        try
//        {
//            FileOutputStream fos = new FileOutputStream("/home/konstas/EDI/wsj/3.0/conll/wsj-10_percy");
//            StringBuilder str = new StringBuilder();
//            for(String line : Utils.readLines("/home/konstas/EDI/wsj/3.0/conll/wsj-10_words_tags"))
//            {
//                if(line.equals(""))
//                {
//                    str.append("\n");
//                    fos.write(str.toString().getBytes());
//                    str = new StringBuilder();
//                }
//                else
//                {
//                    String[] ar = line.split("\t");
//                    str.append(ar[1]).append(" ").append(ar[0]).append(" ");
//                }
//            }
//            fos.close();
//        }
//        catch(IOException ioe)
//        {
//            ioe.printStackTrace();
//        }
//        System.exit(0);
    }
   
    /**
     * Test of main method, of class ExtractRecordsStatistics.
     */
//    @Test
    public void testWeather()
    {     
        String args = 
                   "-exportType recordType "
                 +  "-examplesInSingleFile "
                 +  "-initType staged "
//                 + "-countRepeatedRecords "
                 + "-extractRecordTrees "
                 + "-ruleCountThreshold 5 "
                 + "-binarize right "
                 + "-modifiedBinarization "
                 + "-extractNoneEvent "
                 + "-useEventTypeNames "
//                 + "-countSentenceNgrams "
//                 + "-countDocumentNgrams "
//                 + "-writePermutations "
                 + "-delimitSentences "
                 + "-modelType event3 "
                 + "-inputLists "
                 + "data/weatherGov/weatherGovTrainGabor.gz "
//                 + "test/testWeatherGovEvents "
//                 + "gaborLists/trainListPathsGabor "                 
                 + "-execDir "
                 + "weatherGovLM/recordStatistics "
                 + "-stagedParamsFile "
                    + "results/output/weatherGov/alignments/"
                    + "model_3_gabor_no_sleet_windChill_15iter/stage1.params.obj.gz "
                 + "-predInput "
                 + "results/output/weatherGov/alignments/model_3_gabor_no_sleet_windChill_15iter/stage1.train.pred.14.sorted "
                 + "-excludedEventTypes sleetChance windChill "
                 + "-inputFileExt events ";
//                 + "-ngramWrapper kylm "
//                 + "-ngramModelFile weatherGovLM/gabor-srilm-abs-3-gram.model.arpa ";
//                 + "-posAtSurfaceLevel "
//                 + "-inputPosTagged"; // IMPORTANT        
        ExtractRecordsStatisticsOptions opts = new ExtractRecordsStatisticsOptions();
        Execution.init(args.split(" "), new Object[] {opts}); // parse input params        
        ExtractRecordsStatistics ers = new ExtractRecordsStatistics(opts);
        ers.testExecute();
    }
    
    @Test
    public void testWinHelp()
    {     
        String args = 
                   "-exportType recordType "
                 +  "-examplesInSingleFile "
//                 + "-countRepeatedRecords "
                 + "-extractRecordTrees "
//                 + "-ruleCountThreshold 5 "
                 + "-binarize right "
//                 + "-modifiedBinarization "
                 + "-markovOrder 0 "
                 + "-extractNoneEvent "
                 + "-useEventTypeNames "
//                 + "-countSentenceNgrams "
//                 + "-countDocumentNgrams "
//                 + "-writePermutations "
                 + "-delimitSentences "
                 + "-modelType event3 "
                 + "-inputLists "
                 + "data/branavan/winHelpHLA/winHelpRL.cleaned.objType.norm.docs.single.newAnnotation "
                 + "-execDir data/branava/winHelpHLA "
                 + "-initType random "
                 + "-stagedParamsFile data/branavan/winHelpHLA/stage1.init.params.obj.gz "
//                 + "-predInput "
//                 + "results/output/weatherGov/alignments/model_3_gabor_no_sleet_windChill/stage1.train.pred.14 "
//                 + "-excludedEventTypes sleetChance windChill "
                 + "-inputFileExt events ";
//                 + "-ngramWrapper kylm "
//                 + "-ngramModelFile weatherGovLM/gabor-srilm-abs-3-gram.model.arpa ";
//                 + "-posAtSurfaceLevel "
//                 + "-inputPosTagged"; // IMPORTANT        
        ExtractRecordsStatisticsOptions opts = new ExtractRecordsStatisticsOptions();
        Execution.init(args.split(" "), new Object[] {opts}); // parse input params        
        ExtractRecordsStatistics ers = new ExtractRecordsStatistics(opts);
        ers.testExecute();
    }
}
