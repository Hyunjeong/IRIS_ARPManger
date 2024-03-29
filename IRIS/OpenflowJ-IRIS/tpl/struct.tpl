package $packagename;

import java.nio.ByteBuffer;
import org.openflow.util.*;

$imports

public class $typename $inherit_method $supertype $implements {
    public static int MINIMUM_LENGTH = $minimumlength;
    public static int CORE_LENGTH = $corelength;

    $declarations

    public $typename() {
        $constructor
    }
    
    public $typename($typename other) {
    	$copyconstructor
    }

	$accessors
	
	$builder
	
	public $typename dup() {
		return new $typename(this);
	}
	
    public void readFrom(ByteBuffer data) {
        $readfrom
    }

    public void writeTo(ByteBuffer data) {
    	$superwriteto
        $writeto
    }

    public String toString() {
        $tostring
    }

	// compute length (without final alignment)    
    public short computeLength() {
    	$computelength
    	return len;
    }
    
    // calculate the amount that will be increased by the alignment requirement.
    public short alignment(int total, int req) {
    	return (short)((total + (req-1))/req*req - total);
    }
    
    // compute the difference with MINIMUM_LENGTH (with alignment)
    public short lengthDiff() {
    	short total = computeLength();
    	return (short)(total - (short)MINIMUM_LENGTH + alignment(total, $align));
    }

    @Override
    public int hashCode() {
        $hashcode
    }

    @Override
    public boolean equals(Object obj) {
        $equals
    }
}
