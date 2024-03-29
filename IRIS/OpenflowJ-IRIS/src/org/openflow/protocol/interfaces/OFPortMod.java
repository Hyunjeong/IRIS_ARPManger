package org.openflow.protocol.interfaces;

import java.nio.ByteBuffer;



public interface OFPortMod extends OFMessage {

	public OFPortMod setPortNo(OFPortNo value);
	public OFPortNo getPortNo();
	public boolean isPortNoSupported();
	public OFPortMod setHwAddr(byte[] value);
	public byte[] getHwAddr();
	public boolean isHwAddrSupported();
	public OFPortMod setConfig(int value);
	public int getConfig();
	public boolean isConfigSupported();
	public OFPortMod setMask(int value);
	public int getMask();
	public boolean isMaskSupported();
	public OFPortMod setAdvertise(int value);
	public int getAdvertise();
	public boolean isAdvertiseSupported();
	
	public OFPortMod dup();

    public void readFrom(ByteBuffer data);

    public void writeTo(ByteBuffer data);

    public short computeLength();

    // calculate the amount that will be increased by the alignment requirement.
    public short alignment(int total, int req);
    
    // compute the difference with MINIMUM_LENGTH (with alignment)
    public short lengthDiff();
}
