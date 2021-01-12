package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void whenComparatorByNameStraight() {
        int rsl = new JobSortByNameStraight().compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByNameBack() {
        int rsl = new JobSortByNameBack().compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByPriorityStraight() {
        int rsl = new JobSortByPriorityStraight().compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByPriorityBack() {
        int rsl = new JobSortByPriorityBack().compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByNameAndPriorityStraight() {
        Comparator<Job> combComp = new JobSortByNameStraight().thenComparing(new JobSortByPriorityStraight());
        int rsl = combComp.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameAndPriorityBack() {
        Comparator<Job> combComp = new JobSortByNameBack().thenComparing(new JobSortByPriorityBack());
        int rsl = combComp.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByPriorityStraightAndNameBack() {
        Comparator<Job> combComp = new JobSortByPriorityStraight().thenComparing(new JobSortByNameBack());
        int rsl = combComp.compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByPriorityBackAndNameStraight() {
        Comparator<Job> combComp = new JobSortByPriorityBack().thenComparing(new JobSortByNameStraight());
        int rsl = combComp.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }
}