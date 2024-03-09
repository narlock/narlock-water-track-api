package com.narlock.simplewatertrackapi

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import spock.lang.Specification

@SpringBootTest
class SimpleWaterTrackApiApplicationSpec extends Specification {
    @Autowired
    ApplicationContext applicationContext

    def 'context loads'() {
        expect:
        applicationContext
    }
}
