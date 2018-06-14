package com.example.platform.singleton;

/**
 * @author arjen
 */

public class TimeData {
    private TimeDataControl timeDataControl;

    private TimeData() {
        timeDataControl = new TimeDataControl();
    }

    public String getYear() {
        return timeDataControl.getYear();
    }

    public String getMonth() {
        return timeDataControl.getMonth();
    }

    public String getDay() {
        return timeDataControl.getDay();
    }

    public static class Builder {
        private TimeDataControl.Param param;

        public Builder() {
            param = new TimeDataControl.Param();
        }

        public Builder setYear(String year) {
            param.setYear(year);
            return this;
        }

        public Builder setMonth(String month) {
            param.setMonth(month);
            return this;
        }

        public Builder setDay(String day) {
            param.setDay(day);
            return this;
        }

        public TimeData create() {
            TimeData timeData = new TimeData();
            param.apply(timeData.timeDataControl);
            return timeData;
        }
    }
}
