#!/bin/bash
./java_run_gen.sh data/atis/test/atis-test.txt \
results/output/atis/generation/model_3_40-best_no_null_smooth_0001_STOP \
results/output/atis/alignments/model_3/15_iter_no_null_no_smooth_STOP 40 \
atisLM/atis-all-train-3-gram.model.arpa srilm -examplesInSingleFile
