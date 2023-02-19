package com.seato.nameless.serviceTests;

import com.seato.nameless.data.repositories.PersonRepo;
import com.seato.nameless.services.PersonService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersonServiceTest {
    private PersonService dut;

    @Mock
    private PersonRepo personRepo;

    @BeforeAll
    public void init(){
        dut = new PersonService(personRepo);
    }

    @Test
    public void whenPersonService_GivenNoParam_ThenThrowNullPointerException(){
        Assert.assertThrows(NullPointerException.class, () -> dut.getPersonByName(null, null));
    }


}