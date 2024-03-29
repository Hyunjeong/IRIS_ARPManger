package org.openflow.protocol.ver1_3.messages;

import java.nio.ByteBuffer;
import org.openflow.util.*;

import java.util.LinkedList;
import org.openflow.protocol.OFPort;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import org.openflow.protocol.ver1_3.types.*;

public class OFFlowMod extends OFMessage implements org.openflow.protocol.interfaces.OFFlowMod {
    public static int MINIMUM_LENGTH = 52;
    public static int CORE_LENGTH = 44;

    long  cookie;
	long  cookie_mask;
	byte  table_id;
	OFFlowModCommand  _command;
	short  idle_timeout;
	short  hard_timeout;
	short  priority;
	int  buffer_id;
	int  out_port;
	int  out_group;
	short  flags;
	short pad_1th;
	org.openflow.protocol.interfaces.OFMatchOxm  match;
	List<org.openflow.protocol.interfaces.OFInstruction>  instructions;

    public OFFlowMod() {
        super();
		setLength(U16.t(MINIMUM_LENGTH));
		setType(OFMessageType.valueOf((byte)14));
    }
    
    public OFFlowMod(OFFlowMod other) {
    	super(other);
		this.cookie = other.cookie;
		this.cookie_mask = other.cookie_mask;
		this.table_id = other.table_id;
		this._command = other._command;
		this.idle_timeout = other.idle_timeout;
		this.hard_timeout = other.hard_timeout;
		this.priority = other.priority;
		this.buffer_id = other.buffer_id;
		this.out_port = other.out_port;
		this.out_group = other.out_group;
		this.flags = other.flags;
		this.match = new OFMatchOxm((OFMatchOxm)other.match);
		this.instructions = (other.instructions == null)? null: new LinkedList<org.openflow.protocol.interfaces.OFInstruction>();
		for ( org.openflow.protocol.interfaces.OFInstruction i : other.instructions ) { this.instructions.add( i.dup() ); }
    }

	public long getCookie() {
		return this.cookie;
	}
	
	public OFFlowMod setCookie(long cookie) {
		this.cookie = cookie;
		return this;
	}
	
	@org.codehaus.jackson.annotate.JsonIgnore
	public boolean isCookieSupported() {
		return true;
	}
			
	public long getCookieMask() {
		return this.cookie_mask;
	}
	
	public OFFlowMod setCookieMask(long cookie_mask) {
		this.cookie_mask = cookie_mask;
		return this;
	}
	
	@org.codehaus.jackson.annotate.JsonIgnore
	public boolean isCookieMaskSupported() {
		return true;
	}
			
	public byte getTableId() {
		return this.table_id;
	}
	
	public OFFlowMod setTableId(byte table_id) {
		this.table_id = table_id;
		return this;
	}
	
	@org.codehaus.jackson.annotate.JsonIgnore
	public boolean isTableIdSupported() {
		return true;
	}
			

	public org.openflow.protocol.interfaces.OFFlowModCommand getCommand() {
		return OFFlowModCommand.to(this._command);
	}
	
	public OFFlowMod setCommand(org.openflow.protocol.interfaces.OFFlowModCommand _command) {
		this._command = OFFlowModCommand.from(_command);
		return this;
	}
	
	public OFFlowMod setCommand(OFFlowModCommand _command) {
		this._command = _command;
		return this;
	}

	@org.codehaus.jackson.annotate.JsonIgnore	
	public boolean isCommandSupported() {
		return true;
	}
	
	public short getIdleTimeout() {
		return this.idle_timeout;
	}
	
	public OFFlowMod setIdleTimeout(short idle_timeout) {
		this.idle_timeout = idle_timeout;
		return this;
	}
	
	@org.codehaus.jackson.annotate.JsonIgnore
	public boolean isIdleTimeoutSupported() {
		return true;
	}
			
	public short getHardTimeout() {
		return this.hard_timeout;
	}
	
	public OFFlowMod setHardTimeout(short hard_timeout) {
		this.hard_timeout = hard_timeout;
		return this;
	}
	
	@org.codehaus.jackson.annotate.JsonIgnore
	public boolean isHardTimeoutSupported() {
		return true;
	}
			
	public short getPriority() {
		return this.priority;
	}
	
	public OFFlowMod setPriority(short priority) {
		this.priority = priority;
		return this;
	}
	
	@org.codehaus.jackson.annotate.JsonIgnore
	public boolean isPrioritySupported() {
		return true;
	}
			
	public int getBufferId() {
		return this.buffer_id;
	}
	
	public OFFlowMod setBufferId(int buffer_id) {
		this.buffer_id = buffer_id;
		return this;
	}
	
	@org.codehaus.jackson.annotate.JsonIgnore
	public boolean isBufferIdSupported() {
		return true;
	}
			
	public OFPort getOutPort() {
		return OFPort.of(this.out_port);
	}
	
	public OFFlowMod setOutPort(OFPort port) {
		this.out_port = (int) port.get();
		return this;
	}
	
	@org.codehaus.jackson.annotate.JsonIgnore
	public boolean isOutPortSupported() {
		return true;
	}
	
	public int getOutGroup() {
		return this.out_group;
	}
	
	public OFFlowMod setOutGroup(int out_group) {
		this.out_group = out_group;
		return this;
	}
	
	@org.codehaus.jackson.annotate.JsonIgnore
	public boolean isOutGroupSupported() {
		return true;
	}
			
	public short getFlagsWire() {
		return this.flags;
	}
	
	public OFFlowMod setFlagsWire(short flags) {
		this.flags = flags;
		return this;
	}
	
	public Set<org.openflow.protocol.interfaces.OFFlowModFlags> getFlags() {
		OFFlowModFlags tmp = OFFlowModFlags.of(this.flags);
		Set<org.openflow.protocol.interfaces.OFFlowModFlags> ret = new HashSet<org.openflow.protocol.interfaces.OFFlowModFlags>();
		for ( org.openflow.protocol.interfaces.OFFlowModFlags v : org.openflow.protocol.interfaces.OFFlowModFlags.values() ) {
			if (tmp.has(v)) {
				ret.add(v);
			}
		}
		return ret;
	}
		
	public OFFlowMod setFlags(Set<org.openflow.protocol.interfaces.OFFlowModFlags> values) {
		OFFlowModFlags tmp = OFFlowModFlags.of(this.flags);
		tmp.or( values );
		this.flags = tmp.get();
		return this;
	}
	
	public OFFlowMod setFlags(org.openflow.protocol.interfaces.OFFlowModFlags ... values) {
		OFFlowModFlags tmp = OFFlowModFlags.of(this.flags);
		tmp.or( values );
		this.flags = tmp.get();
		return this;
	}
	
	@org.codehaus.jackson.annotate.JsonIgnore
	public boolean isFlagsSupported() {
		return true;
	}
		
	public org.openflow.protocol.interfaces.OFMatch getMatch() {
		return this.match;
	}
	
	public OFFlowMod setMatch(org.openflow.protocol.interfaces.OFMatch match) {
		this.match = (OFMatchOxm) match;
		return this;
	}
	
	@org.codehaus.jackson.annotate.JsonIgnore
	public boolean isMatchSupported() {
		return true;
	}
			
	public List<org.openflow.protocol.interfaces.OFInstruction> getInstructions() {
		return this.instructions;
	}
	
	public OFFlowMod setInstructions(List<org.openflow.protocol.interfaces.OFInstruction> instructions) {
		this.instructions = instructions;
		return this;
	}
	
	@org.codehaus.jackson.annotate.JsonIgnore
	public boolean isInstructionsSupported() {
		return true;
	}
			
	@org.codehaus.jackson.annotate.JsonIgnore
	public OFFlowMod setActions(List<org.openflow.protocol.interfaces.OFAction> value) {
		throw new UnsupportedOperationException("setActions is not supported operation");
	}
	
	@org.codehaus.jackson.annotate.JsonIgnore
	public List<org.openflow.protocol.interfaces.OFAction> getActions() {
		throw new UnsupportedOperationException("getActions is not supported operation");
	}
	
	@org.codehaus.jackson.annotate.JsonIgnore
	public boolean isActionsSupported() {
		return false;
	}
	
	
	
	
	public OFFlowMod dup() {
		return new OFFlowMod(this);
	}
	
    public void readFrom(ByteBuffer data) {
        int mark = data.position();
		super.readFrom(data);
		this.cookie = data.getLong();
		this.cookie_mask = data.getLong();
		this.table_id = data.get();
		this._command = OFFlowModCommand.valueOf(OFFlowModCommand.readFrom(data));
		this.idle_timeout = data.getShort();
		this.hard_timeout = data.getShort();
		this.priority = data.getShort();
		this.buffer_id = data.getInt();
		this.out_port = data.getInt();
		this.out_group = data.getInt();
		this.flags = data.getShort();
		this.pad_1th = data.getShort();
		if (this.match == null) this.match = new OFMatchOxm();
		this.match.readFrom(data);
		if (this.instructions == null) this.instructions = new LinkedList<org.openflow.protocol.interfaces.OFInstruction>();
		int __cnt = ((int)getLength() - (data.position() - mark));
		while (__cnt > 0) {
		  data.mark();
		  short __t = data.getShort();
		  data.reset();
		  OFInstruction t = OFInstructionType.valueOf(__t).newInstance();
		  t.readFrom(data); __cnt -= t.getLength();
		  this.instructions.add(t);
		}
    }

    public void writeTo(ByteBuffer data) {
    	super.writeTo(data);
        data.putLong(this.cookie);
		data.putLong(this.cookie_mask);
		data.put(this.table_id);
		data.put(this._command.getValue());
		data.putShort(this.idle_timeout);
		data.putShort(this.hard_timeout);
		data.putShort(this.priority);
		data.putInt(this.buffer_id);
		data.putInt(this.out_port);
		data.putInt(this.out_group);
		data.putShort(this.flags);
		data.putShort(this.pad_1th);
		match.writeTo(data);
		if (this.instructions != null ) for (org.openflow.protocol.interfaces.OFInstruction t: this.instructions) { t.writeTo(data); }
    }

    public String toString() {
        return super.toString() +  ":OFFlowMod-"+":cookie=" + U64.f(cookie) + 
		":cookie_mask=" + U64.f(cookie_mask) + 
		":table_id=" + U8.f(table_id) + 
		":_command=" + _command + 
		":idle_timeout=" + U16.f(idle_timeout) + 
		":hard_timeout=" + U16.f(hard_timeout) + 
		":priority=" + U16.f(priority) + 
		":buffer_id=" + U32.f(buffer_id) + 
		":out_port=" + U32.f(out_port) + 
		":out_group=" + U32.f(out_group) + 
		":flags=" + U16.f(flags) + 
		":match=" + match + 
		":instructions=" + instructions;
    }

	// compute length (without final alignment)    
    public short computeLength() {
    	short len = (short)(CORE_LENGTH + super.computeLength());
		len += match.lengthDiff();
		if ( this.instructions != null ) for ( org.openflow.protocol.interfaces.OFInstruction i : this.instructions ) { len += i.computeLength(); }
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
        		
		final int prime = 2083;
		int result = super.hashCode() * prime;
		result = prime * result + (int) cookie;
		result = prime * result + (int) cookie_mask;
		result = prime * result + (int) table_id;
		result = prime * result + ((_command == null)?0:_command.hashCode());
		result = prime * result + (int) idle_timeout;
		result = prime * result + (int) hard_timeout;
		result = prime * result + (int) priority;
		result = prime * result + (int) buffer_id;
		result = prime * result + (int) out_port;
		result = prime * result + (int) out_group;
		result = prime * result + (int) flags;
		result = prime * result + ((match == null)?0:match.hashCode());
		result = prime * result + ((instructions == null)?0:instructions.hashCode());
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
        if (!(obj instanceof OFFlowMod)) {
            return false;
        }
        OFFlowMod other = (OFFlowMod) obj;
		if ( cookie != other.cookie ) return false;
		if ( cookie_mask != other.cookie_mask ) return false;
		if ( table_id != other.table_id ) return false;
		if ( _command == null && other._command != null ) { return false; }
		else if ( !_command.equals(other._command) ) { return false; }
		if ( idle_timeout != other.idle_timeout ) return false;
		if ( hard_timeout != other.hard_timeout ) return false;
		if ( priority != other.priority ) return false;
		if ( buffer_id != other.buffer_id ) return false;
		if ( out_port != other.out_port ) return false;
		if ( out_group != other.out_group ) return false;
		if ( flags != other.flags ) return false;
		if ( match == null && other.match != null ) { return false; }
		else if ( !match.equals(other.match) ) { return false; }
		if ( instructions == null && other.instructions != null ) { return false; }
		else if ( !instructions.equals(other.instructions) ) { return false; }
        return true;
    }
}
