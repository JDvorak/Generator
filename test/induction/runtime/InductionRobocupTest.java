package induction.runtime;

import fig.exec.Execution;
import induction.LearnOptions;
import induction.Options;
import induction.Options.InitType;
import induction.problem.event3.generative.GenerativeEvent3Model;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author konstas
 */
public class InductionRobocupTest
{
    LearnOptions lopts;
    String name;
    GenerativeEvent3Model model;

    public InductionRobocupTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownClass() throws Exception
    {
    }

    @Before
    public void setUp() 
    {
         String args = "-modelType event3 "
                 + "-Options.stage1.numIters 10 "
                 + "-inputLists "
//                 + "test/testRobocupEvents "
                 + "robocupLists/robocupFold1PathsTrain "
                 + "-inputFileExt events "
                 + "-oneEventPerExample 0,-1 "
                 + "-disallowConsecutiveRepeatFields "
                 + "-allowConsecutiveEvents "
                 + "-indepWords 0,5 "
                 + "-binariseAtWordLevel "
                 + "-initNoise 0 "
                 + "-fixedGenericProb 0 "
                 + "-Options.stage1.smoothing 0.1 "
                 + "-dontCrossPunctuation ";
//                 + "-posAtSurfaceLevel "
//                 + "-inputPosTagged ";                // IMPORTANT!

        /*initialisation procedure from Induction class*/
        Options opts = new Options();
        Execution.init(args.split(" "), new Object[] {opts}); // parse input params
        model = new GenerativeEvent3Model(opts);
        model.readExamples();        
        model.logStats();
        opts.outputIterFreq = opts.stage1.numIters;
        model.init(InitType.random, opts.initRandom, "");
        lopts = opts.stage1;
        name = "stage1";
    }

    @After
    public void tearDown() throws Throwable {
    }

    /**
     * Test of run method, of class Induction.
     */
    @Test
    public void testRun()
    {
        System.out.println("run");
        String targetOutput = "0 0 0 0";
        assertEquals(model.testInitLearn(name, lopts).trim(), targetOutput);
    }
}