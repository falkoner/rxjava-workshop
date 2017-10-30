package com.nurkiewicz.rxjava;

import io.reactivex.Single;
import org.junit.Ignore;
import org.junit.Test;

import java.time.Instant;

@Ignore
public class R80_Single {
	
	@Test
	public void simpleSingle() throws Exception {
		Single<Instant> time = Single.create(sub -> {
			sub.onSuccess(Instant.now());
		});
	}

	@Test
	public void test_20() throws Exception {
		// Observable / Flowable	0..infinite
		// Single					1
		// Maybe					0..1
		// Completable				0
	}


}
