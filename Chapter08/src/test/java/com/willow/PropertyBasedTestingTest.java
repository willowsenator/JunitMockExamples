package com.willow;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import com.willow.stateTesting.StringUtils;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitQuickcheck.class)
public class PropertyBasedTestingTest {

    StringUtils stringUtils = new StringUtils();

    @Property(trials = 70)
    public void testReverseString(@From(MyCharacterGenerator.class) String original){
        System.out.println("Generated string for reverseString test " + original);

        assertThat(stringUtils.reverse(stringUtils.reverse(original))).isEqualTo(original);
    }

}