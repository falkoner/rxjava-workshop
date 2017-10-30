package com.nurkiewicz.rxjava;

import io.reactivex.Flowable;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static com.nurkiewicz.rxjava.R30_Zip.LOREM_IPSUM;

@Ignore
public class R31_WindowBuffer {
	
	/**
	 * Hint: use buffer()
	 */
	@Test
	public void everyThirdWordUsingBuffer() throws Exception {
		//given
		Flowable<String> everyThirdWord = LOREM_IPSUM
                .buffer(3)
                .filter(strings -> strings.size() == 3)
                .map(strings -> strings.get(2));
		
		//then
		everyThirdWord
				.test()
				.assertValues("dolor", "consectetur")
				.assertNoErrors();
	}
	
	/**
	 * Hint: use window()
	 * Hint: use elementAt()
	 */
	@Test
	public void everyThirdWordUsingWindow() throws Exception {
		//given
		Flowable<String> everyThirdWord = LOREM_IPSUM
                .window(3)
                .flatMapMaybe(win -> win.elementAt(2));
		
		//then
		everyThirdWord
				.test()
				.assertValues("dolor", "consectetur")
				.assertNoErrors();
	}

    @Test
    public void randomDiceIntervalTest() throws Exception {
        Flowable.interval(100, TimeUnit.MILLISECONDS)
                .map(x -> RandomUtils.nextInt(1, 7))
                .buffer(1, TimeUnit.SECONDS)
                .subscribe(System.out::println);

        TimeUnit.SECONDS.sleep(10);
    }
}
