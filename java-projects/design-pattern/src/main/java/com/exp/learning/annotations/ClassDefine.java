package com.exp.learning.annotations;

import java.lang.annotation.Documented;

@Documented
public @interface ClassDefine {
	String className();
	String description();
	String author();
	String date();
	int currentVersion();
	String[] reviews();
}