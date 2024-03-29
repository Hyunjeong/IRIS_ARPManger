package org.openflow.protocol.ver1_0.messages;

import java.nio.ByteBuffer;
import org.openflow.util.*;

import org.openflow.protocol.ver1_0.types.*;

public class OFError extends OFMessage implements org.openflow.protocol.interfaces.OFError {
    public static int MINIMUM_LENGTH = 12;
    public static int CORE_LENGTH = 4;

    OFErrorCode  error_code;
	short  subcode;
	byte[]  data;

    public OFError() {
        super();
		setLength(U16.t(MINIMUM_LENGTH));
		setType(OFMessageType.valueOf((byte)1));
    }
    
    public OFError(OFError other) {
    	super(other);
		this.error_code = other.error_code;
		this.subcode = other.subcode;
		if (other.data != null) { this.data = java.util.Arrays.copyOf(other.data, other.data.length); }
    }

	public org.openflow.protocol.interfaces.OFErrorCode getErrorCode() {
		return OFErrorCode.to(this.error_code);
	}
	
	public OFError setErrorCode(org.openflow.protocol.interfaces.OFErrorCode error_code) {
		this.error_code = OFErrorCode.from(error_code);
		return this;
	}
	
	public OFError setErrorCode(OFErrorCode error_code) {
		this.error_code = error_code;
		return this;
	}

	@org.codehaus.jackson.annotate.JsonIgnore	
	public boolean isErrorCodeSupported() {
		return true;
	}
	
	public short getSubcode() {
		return this.subcode;
	}
	
	public OFError setSubcode(short subcode) {
		this.subcode = subcode;
		return this;
	}
	
	@org.codehaus.jackson.annotate.JsonIgnore
	public boolean isSubcodeSupported() {
		return true;
	}
			
	public byte[] getData() {
		return this.data;
	}
	
	public OFError setData(byte[] data) {
		this.data = data;
		return this;
	}
	
	@org.codehaus.jackson.annotate.JsonIgnore
	public boolean isDataSupported() {
		return true;
	}
			
	
	
	
	public OFError dup() {
		return new OFError(this);
	}
	
    public void readFrom(ByteBuffer data) {
        int mark = data.position();
		super.readFrom(data);
		this.error_code = OFErrorCode.valueOf(OFErrorCode.readFrom(data));
		this.subcode = data.getShort();
		if ( this.data == null ) this.data = new byte[(getLength() - (data.position() - mark))];
		data.get(this.data);
    }

    public void writeTo(ByteBuffer data) {
    	super.writeTo(data);
        data.putShort(this.error_code.getValue());
		data.putShort(this.subcode);
		if ( this.data != null ) { data.put(this.data); }
    }

    public String toString() {
        return super.toString() +  ":OFError-"+":error_code=" + error_code + 
		":subcode=" + U16.f(subcode) + 
		":data=" + java.util.Arrays.toString(data);
    }

	// compute length (without final alignment)    
    public short computeLength() {
    	short len = (short)(CORE_LENGTH + super.computeLength());
		if ( this.data != null ) { len += this.data.length; } 
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
        		
		final int prime = 2689;
		int result = super.hashCode() * prime;
		result = prime * result + ((error_code == null)?0:error_code.hashCode());
		result = prime * result + (int) subcode;
		result = prime * result + ((data == null)?0:java.util.Arrays.hashCode(data));
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
        if (!(obj instanceof OFError)) {
            return false;
        }
        OFError other = (OFError) obj;
		if ( error_code == null && other.error_code != null ) { return false; }
		else if ( !error_code.equals(other.error_code) ) { return false; }
		if ( subcode != other.subcode ) return false;
		if ( data == null && other.data != null ) { return false; }
		else if ( !java.util.Arrays.equals(data, other.data) ) { return false; }
        return true;
    }
}
