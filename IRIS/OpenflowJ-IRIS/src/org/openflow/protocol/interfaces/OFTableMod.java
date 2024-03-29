package org.openflow.protocol.interfaces;

import java.nio.ByteBuffer;



public interface OFTableMod extends OFMessage {

	public OFTableMod setTableId(byte value);
	public byte getTableId();
	public boolean isTableIdSupported();
	public OFTableMod setConfig(int value);
	public int getConfig();
	public boolean isConfigSupported();
	
	public OFTableMod dup();

    public void readFrom(ByteBuffer data);

    public void writeTo(ByteBuffer data);

    public short computeLength();

    // calculate the amount that will be increased by the alignment requirement.
    public short alignment(int total, int req);
    
    // compute the difference with MINIMUM_LENGTH (with alignment)
    public short lengthDiff();
}
