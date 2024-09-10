package com.dydko.date1;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Test123 {
    LOW("123"),
    MEDIUM("fdf"),
    HIGH("fds");

    private final String val;
}
