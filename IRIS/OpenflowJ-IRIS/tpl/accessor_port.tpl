	public OFPort get${method_name}() {
		return OFPort.of(this.$variable_name);
	}
	
	public $class_name set${method_name}(OFPort port) {
		this.$variable_name = ($return_type) port.get();
		return this;
	}
	
	@org.codehaus.jackson.annotate.JsonIgnore
	public boolean is${method_name}Supported() {
		return true;
	}
	