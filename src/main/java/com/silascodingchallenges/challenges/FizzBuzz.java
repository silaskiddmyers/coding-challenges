package com.silascodingchallenges.challenges;

public class FizzBuzz {
    public String exec(int n) {
        StringBuilder result = new StringBuilder();

        for(int i = 1;i <= n; i++) {
            if(i % 3 == 0) {
                result.append("Fizz");
            }
            if(i % 5 == 0) {
                result.append("Buzz");
            }
            if(i % 3 != 0 && i % 5 != 0) {
                result.append(i);
            }
            if(i!=n) {
                result.append(", ");
            }
        }


        return result.toString();
    }
}