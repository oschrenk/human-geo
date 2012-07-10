package com.oschrenk.humangeo.io;

/**
 * The Enum Mask.
 */
public enum Mask {

	// For each position two bits are need
	// 00b = 1st, 01b = 2nd, 10b = 3rd
	// to describe the position in the array
	// so a 3d-array in "normal" position "123" is
	// 00 00 01 10
	// with the first two bits as wasted space

	// @formatter:off
	_123((0 << 4) + (1 << 2) + (2 << 0)), //
	_132((0 << 4) + (1 << 0) + (2 << 2)), //
	_213((0 << 2) + (1 << 4) + (2 << 0)), //
	_231((0 << 0) + (1 << 4) + (2 << 2)), //
	_312((0 << 2) + (1 << 0) + (2 << 4)), //
	_321((0 << 0) + (1 << 2) + (2 << 4)); //
	// @formatter:on

	private final int mask;

	Mask(final int mask) {
		this.mask = mask;
	}

	public int getMask() {
		return mask;
	}

}
