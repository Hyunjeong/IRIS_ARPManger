package org.openflow.protocol.ver1_3.messages;

import java.nio.ByteBuffer;
import org.openflow.util.*;

import org.openflow.protocol.ver1_3.types.*;

public class OFMatchStandard extends OFMatch implements org.openflow.protocol.interfaces.OFMatchStandard {
    public static int MINIMUM_LENGTH = 4;
    public static int CORE_LENGTH = 0;

    

    public OFMatchStandard() {
        super();
		setLength(U16.t(MINIMUM_LENGTH));
		setType(OFMatchType.valueOf((short)0));
    }
    
    public OFMatchStandard(OFMatchStandard other) {
    	super(other);
    }

	
	
	
	
	public OFMatchStandard dup() {
		return new OFMatchStandard(this);
	}
	
    public void readFrom(ByteBuffer data) {
        super.readFrom(data);
    }

    public void writeTo(ByteBuffer data) {
    	super.writeTo(data);
        
    }

    public String toString() {
        return super.toString() +  ":OFMatchStandard";
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
        		
		final int prime = 2309;
		int result = super.hashCode() * prime;
		
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
        if (!(obj instanceof OFMatchStandard)) {
            return false;
        }
        
        return true;
    }
}
