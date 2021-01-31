package ru.job4j.stream;

import org.junit.Test;

import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void whenCollectTwoAddresses() {
        Address firstAddress = new Address("Moscow", "Novaya", "22", "100");
        Address secondAddress = new Address("St.Petersburg", "Nevskiy prospekt", "15", "16");
        List<Address> rsl = Profiles.collect(List.of(new Profile(firstAddress),
                new Profile(secondAddress)));
        assertThat(rsl.get(0).getCity(), is("Moscow"));
    }
}