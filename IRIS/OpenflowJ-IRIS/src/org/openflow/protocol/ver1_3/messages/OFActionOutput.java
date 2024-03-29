package org.openflow.protocol.ver1_3.messages;

import java.nio.ByteBuffer;
import org.openflow.util.*;

import org.openflow.protocol.ver1_3.types.*;
import org.openflow.protocol.OFPort;

public class OFActionOutput extends OFAction implements org.openflow.protocol.interfaces.OFActionOutput {
    public static int MINIMUM_LENGTH = 16;
    public static int CORE_LENGTH = 12;

    int  port;
	short  max_length;
	int pad_1th;
	short pad_2th;

    public OFActionOutput() {
        super();
		setLength(U16.t(MINIMUM_LENGTH));
		setType(OFActionType.valueOf((short)0));
    }
    
    public OFActionOutput(OFActionOutput other) {
    	super(other);
		this.port = other.port;
		this.max_length = other.max_length;
    }

	public OFPort getPort() {
		return OFPort.of(this.port);
	}
	
	public OFActionOutput setPort(OFPort port) {
		this.port = (int) port.get();
		return this;
	}
	
	@org.codehaus.jackson.annotate.JsonIgnore
	public boolean isPortSupported() {
		return true;
	}
	
	public short getMaxLength() {
		return this.max_length;
	}
	
	public OFActionOutput setMaxLength(short max_length) {
		this.max_length = max_length;
		return this;
	}
	
	@org.codehaus.jackson.annotate.JsonIgnore
	public boolean isMaxLengthSupported() {
		return true;
	}
			
	
	
	
	public OFActionOutput dup() {
		return new OFActionOutput(this);
	}
	
    public void readFrom(ByteBuffer data) {
        super.readFrom(data);
		this.port = data.getInt();
		this.max_length = data.getShort();
		this.pad_1th = data.getInt();
		this.pad_2th = data.getShort();
    }

    public void writeTo(ByteBuffer data) {
    	super.writeTo(data);
        data.putInt(this.port);
		data.putShort(this.max_length);
		data.putInt(this.pad_1th);
		data.putShort(this.pad_2th);
    }

    public String toString() {
        return super.toString() +  ":OFActionOutput-"+":port=" + U32.f(port) + 
		":max_length=" + U16.f(max_length);
    }

	// compute length (without final alignment)    
    public short computeLength() {
    	short len = (short)(CORE_LENGTH + super.computeLength());
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
        		
		final int prime = 2281;
		int result = super.hashCode() * prime;
		result = prime * result + (int) port;
		result = prime * result + (int) max_length;
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
        if (!(obj instanceof OFActionOutput)) {
            return false;
        }
        OFActionOutput other = (OFActionOutput) obj;
		if ( port != other.port ) return false;
		if ( max_length != other.max_length ) return false;
        return true;
    }
}
