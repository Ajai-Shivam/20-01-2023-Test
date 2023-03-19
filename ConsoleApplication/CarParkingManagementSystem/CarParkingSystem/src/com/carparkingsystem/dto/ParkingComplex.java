package com.carparkingsystem.dto;
    public class ParkingComplex {
        private String plotComplexName;
        private int chargeForHr;
        private int noOfSlots;
        private static String[][] slots;

        public ParkingComplex(String plotComplexName, int noOfSlots, int chargeForHr) {
            this.plotComplexName = plotComplexName;
            this.chargeForHr = chargeForHr;
            this.noOfSlots = noOfSlots;
            slots = new String[noOfSlots/5][5];
        }

        public String getPlotComplexName() {
            return plotComplexName;
        }

        public void setPlotComplexName(String plotComplexName) {
            this.plotComplexName = plotComplexName;
        }

        public int getChargeForHr() {
            return chargeForHr;
        }

        public void setChargeForHr(int chargeForHr) {
            this.chargeForHr = chargeForHr;
        }

        public int getNoOfSlots() {
            return noOfSlots;
        }

        public void setNoOfSlots(int noOfSlots) {
            this.noOfSlots = noOfSlots;
        }

        public static String[][] getSlots() {
            return slots;
        }

        public static void setSlots(String[][] slots) {
            ParkingComplex.slots = slots;
        }
    }
