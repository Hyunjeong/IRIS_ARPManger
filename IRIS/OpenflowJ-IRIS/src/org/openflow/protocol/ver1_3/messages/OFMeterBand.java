package org.openflow.protocol.ver1_3.messages;

import java.nio.ByteBuffer;
import org.openflow.util.*;

import org.openflow.protocol.ver1_3.types.*;

public class OFMeterBand   implements org.openflow.protocol.interfaces.OFMeterBand {
    public static int MINIMUM_LENGTH = 12;
    public static int CORE_LENGTH = 12;

    OFMeterBandType  type;
	short  length;
	int  rate;
	int  burst_size;

    public OFMeterBand() {
        
    }
    
    public OFMeterBand(OFMeterBand other) {
    	this.type = other.type;
		this.length = other.length;
		this.rate = other.rate;
		this.burst_size = other.burst_size;
    }

	public org.openflow.protocol.interfaces.OFMeterBandType getType() {
		return OFMeterBandType.to(this.type);
	}
	
	public OFMeterBand setType(org.openflow.protocol.interfaces.OFMeterBandType type) {
		this.type = OFMeterBandType.from(type);
		return this;
	}
	
	public OFMeterBand setType(OFMeterBandType type) {
		this.type = type;
		return this;
	}

	@org.codehaus.jackson.annotate.JsonIgnore	
	public boolean isTypeSupported() {
		return true;
	}
	
	public short getLength() {
		return this.length;
	}
	
	public OFMeterBand setLength(short length) {
		this.length = length;
		return this;
	}
	
	@org.codehaus.jackson.annotate.JsonIgnore
	public boolean isLengthSupported() {
		return true;
	}
			
	public int getRate() {
		return this.rate;
	}
	
	public OFMeterBand setRate(int rate) {
		this.rate = rate;
		return this;
	}
	
	@org.codehaus.jackson.annotate.JsonIgnore
	public boolean isRateSupported() {
		return true;
	}
			
	public int getBurstSize() {
		return this.burst_size;
	}
	
	public OFMeterBand setBurstSize(int burst_size) {
		this.burst_size = burst_size;
		return this;
	}
	
	@org.codehaus.jackson.annotate.JsonIgnore
	public boolean isBurstSizeSupported() {
		return true;
	}
			
	
	
	
	public OFMeterBand dup() {
		return new OFMeterBand(this);
	}
	
    public void readFrom(ByteBuffer data) {
        this.type = OFMeterBandType.valueOf(OFMeterBandType.readFrom(data));
		this.length = data.getShort();
		this.rate = data.getInt();
		this.burst_size = data.getInt();
    }

    public void writeTo(ByteBuffer data) {
    	
        data.putShort(this.type.getTypeValue());
		data.putShort(this.length);
		data.putInt(this.rate);
		data.putInt(this.burst_size);
    }

    public String toString() {
        return  ":OFMeterBand-"+":type=" + type + 
		":length=" + U16.f(length) + 
		":rate=" + U32.f(rate) + 
		":burst_size=" + U32.f(burst_size);
    }

	// compute length (without final alignment)    
    public short computeLength() {
    	short len = (short)MINIMUM_LENGTH;
    	return len;
    }
    
    // calculate the amount that will be increased by the alignment requirement.
    public short alignment(int total, int req) {
    	return (short)((total + (req-1))/req*req - total);
    }
    
    // compute the difference with MINIMUM_LENGTH (with alignment)
    public short lengthDiff() {
    	short total = computeLength();
    	return (short)(total - (short)MINIMUM_LENGTH + alignment(total, 0));
    }

    @Override
    public int hashCode() {
        		
		final int prime = 1999;
		int result = super.hashCode() * prime;
		result = prime * result + ((type == null)?0:type.hashCode());
		result = prime * result + (int) length;
		result = prime * result + (int) rate;
		result = prime * result + (int) burst_size;
		return result;
    }

    @Override
    public boolean equals(Object obj) {
        
		if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof OFMeterBand)) {
            return false;
        }
        OFMeterBand other = (OFMeterBand) obj;
		if ( type == null && other.type != null ) { return false; }
		else if ( !type.equals(other.type) ) { return false; }
		if ( length != other.length ) return false;
		if ( rate != other.rate ) return false;
		if ( burst_size != other.burst_size ) return false;
        return true;
    }
}
