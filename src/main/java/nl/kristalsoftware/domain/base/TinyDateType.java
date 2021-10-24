package nl.kristalsoftware.domain.base;


import nl.kristalsoftware.domain.base.annotations.ValueObject;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@ValueObject
public abstract class TinyDateType extends TinyType<LocalDate> {

	protected TinyDateType(LocalDate value) {
		super(value);
	}

	protected TinyDateType(Long value) {
		super(null);
	}

	@Override
	public Boolean isEmpty() {
		return getValue() == null;
	}

	public long getDateInMillis() {
		return getEpochMilliFromLocalDate(getValue());
	}

	private long getEpochMilliFromLocalDate(LocalDate localDate) {
		return localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
	}

	public static LocalDate getLocalDateFromMillis(Long date) {
		Instant instant = Instant.ofEpochMilli(date);
		return LocalDate.ofInstant(instant, ZoneId.systemDefault());
	}

}
