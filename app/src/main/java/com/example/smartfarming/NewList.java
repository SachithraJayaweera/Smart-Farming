package com.example.smartfarming;

public class NewList {
        private String seed;

        public NewList(String seed) {
            this.seed = seed;
        }

        public String getSeed() {
            return seed;
        }

        public void setSeed(String seed) {
            this.seed = seed;
        }

       @Override
    public String toString(){
            return seed;
        }

}
