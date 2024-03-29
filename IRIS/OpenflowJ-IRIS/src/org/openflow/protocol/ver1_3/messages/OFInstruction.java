package org.openflow.protocol.ver1_3.messages;

import java.nio.ByteBuffer;
import org.openflow.util.*;

import org.openflow.protocol.ver1_3.types.*;

public class OFInstruction   implements org.openflow.protocol.interfaces.OFInstruction {
    public static int MINIMUM_LENGTH = 4;
    public static int CORE_LENGTH = 4;

    OFInstructionType  type;
	short  length;

    public OFInstruction() {
        
    }
    
    public OFInstruction(OFInstruction other) {
    	this.type = other.type;
		this.length = other.length;
    }

	public org.openflow.protocol.interfaces.OFInstructionType getType() {
		return OFInstructionType.to(this.type);
	}
	
	public OFInstruction setType(org.openflow.protocol.interfaces.OFInstructionType type) {
		this.type = OFInstructionType.from(type);
		return this;
	}
	
	public OFInstruction setType(OFInstructionType type) {
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
	
	public OFInstruction setLength(short length) {
		this.length = length;
		return this;
	}
	
	@org.codehaus.jackson.annotate.JsonIgnore
	public boolean isLengthSupported() {
		return true;
	}
			
	
	
	
	public OFInstruction dup() {
		return new OFInstruction(this);
	}
	
    public void readFrom(ByteBuffer data) {
        this.type = OFInstructionType.valueOf(OFInstructionType.readFrom(data));
		this.length = data.getShort();
    }

    public void writeTo(ByteBuffer data) {
    	
        data.putShort(this.type.getTypeValue());
		data.putShort(this.length);
    }

    public String toString() {
        return  ":OFInstruction-"+":type=" + type + 
		":length=" + U16.f(length);
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
        		
		final int prime = 2137;
		int result = super.hashCode() * prime;
		result = prime * result + ((type == null)?0:type.hashCode());
		result = prime * result + (int) length;
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
        if (!(obj instanceof OFInstruction)) {
            return false;
        }
        OFInstruction other = (OFInstruction) obj;
		if ( type == null && other.type != null ) { return false; }
		else if ( !type.equals(other.type) ) { return false; }
		if ( length != other.length ) return false;
        return true;
    }
}
