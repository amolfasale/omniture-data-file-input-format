package com.tgam.hadoop.mapred;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

import java.io.IOException;

/**
 * Format is a bit more generic than the Omniture format. Does not enforce the number of fields.
 * Also does not strip out tabs, new line etc. Hive can handle these character natively using the ESCAPED BY syntax.
 *
 * @author: maxhansmire
 * @since: 7/19/12
 */
public class EscapedTextInputFormat extends TextInputFormat {
    @Override
    public RecordReader<LongWritable, Text> getRecordReader(
            InputSplit genericSplit, JobConf job,
            Reporter reporter)
            throws IOException {

        reporter.setStatus(genericSplit.toString());
        return new EscapedLineRecordReader(job, (FileSplit) genericSplit);
    }
}