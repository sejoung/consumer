package com.github.sejoung.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author kim se joung
 */
@ToString
@Setter
@Getter
public class MonitorData {

    @JsonProperty("test")
    private String data;


}
