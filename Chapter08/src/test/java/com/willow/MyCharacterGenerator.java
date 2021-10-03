package com.willow;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class MyCharacterGenerator extends Generator<String> {

    private static final String LOWERCASE_CHARS = "abcdefghijklmnñopqrstuvwxyz";
    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String ALL_MY_CHARS = LOWERCASE_CHARS + UPPERCASE_CHARS + NUMBERS;
    private static final int CAPACITY = 60;

    public MyCharacterGenerator() {
        super(String.class);
    }

    @Override
    public String generate(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {
        StringBuilder sb = new StringBuilder(CAPACITY);

        for(int i=0; i < CAPACITY; i++){
            int index = sourceOfRandomness.nextInt(ALL_MY_CHARS.length());
            sb.append(ALL_MY_CHARS.charAt(index));
        }
        return  sb.toString();
    }
}
