package org.openflow.protocol.interfaces;

import java.nio.ByteBuffer;

import java.util.List;

public interface OFTableFeaturePropertyWildcards extends OFTableFeatureProperty {

	public OFTableFeaturePropertyWildcards setOxmIds(List<Integer> value);
	public List<Integer> getOxmIds();
	public boolean isOxmIdsSupported();
	
	public OFTableFeaturePropertyWildcards dup();

    public void readFrom(ByteBuffer data);

    public void writeTo(ByteBuffer data);

    public short computeLength();

    // calculate the amount that will be increased by the alignment requirement.
    public short alignment(int total, int req);
    
    // compute the difference with MINIMUM_LENGTH (with alignment)
    public short lengthDiff();
}
