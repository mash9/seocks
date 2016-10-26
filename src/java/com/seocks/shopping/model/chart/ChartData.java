package com.seocks.shopping.model.chart;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by com on 2016-10-26.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChartData {
    private List<String> labels;
    private List<DataSet> datasets;

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<DataSet> getDatasets() {
        return datasets;
    }

    public void setDatasets(List<DataSet> datasets) {
        this.datasets = datasets;
    }
}
