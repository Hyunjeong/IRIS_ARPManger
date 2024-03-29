package org.openflow.protocol.ver1_0.messages;

import java.nio.ByteBuffer;
import org.openflow.util.*;

import org.openflow.protocol.ver1_0.types.*;

public class OFActionSetNwTos extends OFAction implements org.openflow.protocol.interfaces.OFActionSetNwTos {
    public static int MINIMUM_LENGTH = 8;
    public static int CORE_LENGTH = 4;

    byte  nw_tos;
	short pad_1th;
	byte pad_2th;

    public OFActionSetNwTos() {
        super();
		setLength(U16.t(MINIMUM_LENGTH));
		setType(OFActionType.valueOf((short)8));
    }
    
    public OFActionSetNwTos(OFActionSetNwTos other) {
    	super(other);
		this.nw_tos = other.nw_tos;
    }

	public byte getNwTos() {
		return this.nw_tos;
	}
	
	public OFActionSetNwTos setNwTos(byte nw_tos) {
		this.nw_tos = nw_tos;
		return this;
	}
	
	@org.codehaus.jackson.annotate.JsonIgnore
	public boolean isNwTosSupported() {
		return true;
	}
			
	
	
	
	public OFActionSetNwTos dup() {
		return new OFActionSetNwTos(this);
	}
	
    public void readFrom(ByteBuffer data) {
        super.readFrom(data);
		this.nw_tos = data.get();
		this.pad_1th = data.getShort();
		this.pad_2th = data.get();
    }

    public void writeTo(ByteBuffer data) {
    	super.writeTo(data);
        data.put(this.nw_tos);
		data.putShort(this.pad_1th);
		data.put(this.pad_2th);
    }

    public String toString() {
        return super.toString() +  ":OFActionSetNwTos-"+":nw_tos=" + U8.f(nw_tos);
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
        		
		final int prime = 2767;
		int result = super.hashCode() * prime;
		result = prime * result + (int) nw_tos;
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
        if (!(obj instanceof OFActionSetNwTos)) {
            return false;
        }
        OFActionSetNwTos other = (OFActionSetNwTos) obj;
		if ( nw_tos != other.nw_tos ) return false;
        return true;
    }
}
