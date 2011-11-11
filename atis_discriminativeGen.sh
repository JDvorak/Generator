#!/bin/bash

inputLists=data/atis/test/atis-test.txt
#inputLists=test/testAtisExamples
execDir=results/output/atis/generation/discriminative/calculate_baseline_weight_norm_gen_all
numThreads=2
stagedParamsFile=results/output/atis/generation/discriminative/calculate_baseline_weight_norm/stage1.discriminative.params.obj
baselineModel=results/output/atis/alignments/model_3/prior_0.01/stage1.params.obj

java -Xmx6g -ea -cp dist/Generator.jar:dist/lib/Helper.jar:dist/lib/kylm.jar:dist/lib/meteor.jar:dist/lib/tercom.jar:\dist/lib/srilmWrapper:\
dist/stanford-postagger-2010-05-26.jar -Djava.library.path=lib/wrappers induction.runtime.DiscriminativeInduction \
-create \
-examplesInSingleFile \
-modeltype generate \
-inputLists ${inputLists} \
-execDir ${execDir} \
-inputFileExt events \
-numThreads ${numThreads} \
-disallowConsecutiveRepeatFields \
-stagedParamsFile ${stagedParamsFile} \
-generativeModelParamsFile ${baselineModel} \
-outputExampleFreq 100 \
-outputFullPred \
-ngramModelFile atisLM/atis-all-train-3-gram.model.arpa \
-ngramWrapper srilm \
-allowConsecutiveEvents \
-reorderType eventType \
-maxPhraseLength 5 \
-binariseAtWordLevel \
-ngramSize 3
#-lengthPredictionModelFile data/atis/train/lengthPrediction.counts.linear-reg.model \
#-lengthPredictionFeatureType COUNTS \
#-lengthPredictionStartIndex 2 \
#-lengthCompensation 0
#-allowNoneEvent \
#-conditionNoneEvent