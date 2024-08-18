package com.dydko.winterbe.stream1.annottion;

import java.lang.annotation.Repeatable;

@interface Hints {
    Hint[] value();
}

@Repeatable(Hints.class)
@interface Hint {
    String value();
}