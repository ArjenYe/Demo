package com.example.platform.singleton;

import android.text.TextUtils;

/**
 * @author arjen
 */

public class TimeDataControl {
    private String year;
    private String month;
    private String day;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    static class Param {
        private String year;
        private String month;
        private String day;

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public void apply(TimeDataControl timeDataControl) {
            if (!TextUtils.isEmpty(getYear())) {
                timeDataControl.setYear(getYear());
            }
            if (!TextUtils.isEmpty(getMonth())) {
                timeDataControl.setMonth(getMonth());
            }
            if (!TextUtils.isEmpty(getDay())) {
                timeDataControl.setDay(getDay());
            }
        }
    }
}
