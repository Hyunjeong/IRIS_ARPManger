package org.openflow.protocol.interfaces;

import java.nio.ByteBuffer;



public interface OFActionSetTpSrc extends OFAction {

	public OFActionSetTpSrc setTpPort(short value);
	public short getTpPort();
	public boolean isTpPortSupported();
	
	public OFActionSetTpSrc dup();

    public void readFrom(ByteBuffer data);

    public void writeTo(ByteBuffer data);

    public short computeLength();

    // calculate the amount that will be increased by the alignment requirement.
    public short alignment(int total, int req);
    
    // compute the difference with MINIMUM_LENGTH (with alignment)
    public short lengthDiff();
}
