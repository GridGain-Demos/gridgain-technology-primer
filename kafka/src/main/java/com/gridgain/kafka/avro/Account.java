package com.gridgain.kafka.avro;

import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.SchemaStore;
import org.apache.avro.specific.SpecificData;

@org.apache.avro.specific.AvroGenerated
public class Account extends org.apache.avro.specific.SpecificRecordBase
		implements org.apache.avro.specific.SpecificRecord {
	private static final long serialVersionUID = 4829986413266866397L;

	public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse(
			"{\"type\":\"record\",\"name\":\"Account\",\"namespace\":\"com.gridgain.dih.kafka.avro\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Account Id\"},{\"name\":\"name\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"doc\":\"Stock Name\"}],\"version\":\"1\"}");

	public static org.apache.avro.Schema getClassSchema() {
		return SCHEMA$;
	}

	private static final SpecificData MODEL$ = new SpecificData();

	private static final BinaryMessageEncoder<Account> ENCODER = new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

	private static final BinaryMessageDecoder<Account> DECODER = new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

	/**
	 * Return the BinaryMessageEncoder instance used by this class.
	 * 
	 * @return the message encoder used by this class
	 */
	public static BinaryMessageEncoder<Account> getEncoder() {
		return ENCODER;
	}

	/**
	 * Return the BinaryMessageDecoder instance used by this class.
	 * 
	 * @return the message decoder used by this class
	 */
	public static BinaryMessageDecoder<Account> getDecoder() {
		return DECODER;
	}

	/**
	 * Create a new BinaryMessageDecoder instance for this class that uses the
	 * specified {@link SchemaStore}.
	 * 
	 * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
	 * @return a BinaryMessageDecoder instance for this class backed by the given
	 *         SchemaStore
	 */
	public static BinaryMessageDecoder<Account> createDecoder(SchemaStore resolver) {
		return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
	}

	/**
	 * Serializes this Account to a ByteBuffer.
	 * 
	 * @return a buffer holding the serialized data for this instance
	 * @throws java.io.IOException if this instance could not be serialized
	 */
	public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
		return ENCODER.encode(this);
	}

	/**
	 * Deserializes a Account from a ByteBuffer.
	 * 
	 * @param b a byte buffer holding serialized data for an instance of this class
	 * @return a Account instance decoded from the given buffer
	 * @throws java.io.IOException if the given bytes could not be deserialized into
	 *                             an instance of this class
	 */
	public static Account fromByteBuffer(java.nio.ByteBuffer b) throws java.io.IOException {
		return DECODER.decode(b);
	}

	/** Account Id */
	private java.lang.String id;
	/** Stock Name */
	private java.lang.String name;

	/**
	 * Default constructor. Note that this does not initialize fields to their
	 * default values from the schema. If that is desired then one should use
	 * <code>newBuilder()</code>.
	 */
	public Account() {
	}

	/**
	 * All-args constructor.
	 * 
	 * @param id   Account Id
	 * @param name Stock Name
	 */
	public Account(java.lang.String id, java.lang.String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public org.apache.avro.specific.SpecificData getSpecificData() {
		return MODEL$;
	}

	@Override
	public org.apache.avro.Schema getSchema() {
		return SCHEMA$;
	}

	// Used by DatumWriter. Applications should not call.
	@Override
	public java.lang.Object get(int field$) {
		switch (field$) {
		case 0:
			return id;
		case 1:
			return name;
		default:
			throw new IndexOutOfBoundsException("Invalid index: " + field$);
		}
	}

	// Used by DatumReader. Applications should not call.
	@Override
	public void put(int field$, java.lang.Object value$) {
		switch (field$) {
		case 0:
			id = value$ != null ? value$.toString() : null;
			break;
		case 1:
			name = value$ != null ? value$.toString() : null;
			break;
		default:
			throw new IndexOutOfBoundsException("Invalid index: " + field$);
		}
	}

	/**
	 * Gets the value of the 'id' field.
	 * 
	 * @return Account Id
	 */
	public java.lang.String getId() {
		return id;
	}

	/**
	 * Sets the value of the 'id' field. Account Id
	 * 
	 * @param value the value to set.
	 */
	public void setId(java.lang.String value) {
		this.id = value;
	}

	/**
	 * Gets the value of the 'name' field.
	 * 
	 * @return Stock Name
	 */
	public java.lang.String getName() {
		return name;
	}

	/**
	 * Sets the value of the 'name' field. Stock Name
	 * 
	 * @param value the value to set.
	 */
	public void setName(java.lang.String value) {
		this.name = value;
	}

	/**
	 * Creates a new Account RecordBuilder.
	 * 
	 * @return A new Account RecordBuilder
	 */
	public static com.gridgain.kafka.avro.Account.Builder newBuilder() {
		return new com.gridgain.kafka.avro.Account.Builder();
	}

	/**
	 * Creates a new Account RecordBuilder by copying an existing Builder.
	 * 
	 * @param other The existing builder to copy.
	 * @return A new Account RecordBuilder
	 */
	public static com.gridgain.kafka.avro.Account.Builder newBuilder(
			com.gridgain.kafka.avro.Account.Builder other) {
		if (other == null) {
			return new com.gridgain.kafka.avro.Account.Builder();
		} else {
			return new com.gridgain.kafka.avro.Account.Builder(other);
		}
	}

	/**
	 * Creates a new Account RecordBuilder by copying an existing Account instance.
	 * 
	 * @param other The existing instance to copy.
	 * @return A new Account RecordBuilder
	 */
	public static com.gridgain.kafka.avro.Account.Builder newBuilder(com.gridgain.kafka.avro.Account other) {
		if (other == null) {
			return new com.gridgain.kafka.avro.Account.Builder();
		} else {
			return new com.gridgain.kafka.avro.Account.Builder(other);
		}
	}

	/**
	 * RecordBuilder for Account instances.
	 */
	@org.apache.avro.specific.AvroGenerated
	public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Account>
			implements org.apache.avro.data.RecordBuilder<Account> {

		/** Account Id */
		private java.lang.String id;
		/** Stock Name */
		private java.lang.String name;

		/** Creates a new Builder */
		private Builder() {
			super(SCHEMA$, MODEL$);
		}

		/**
		 * Creates a Builder by copying an existing Builder.
		 * 
		 * @param other The existing Builder to copy.
		 */
		private Builder(com.gridgain.kafka.avro.Account.Builder other) {
			super(other);
			if (isValidValue(fields()[0], other.id)) {
				this.id = data().deepCopy(fields()[0].schema(), other.id);
				fieldSetFlags()[0] = other.fieldSetFlags()[0];
			}
			if (isValidValue(fields()[1], other.name)) {
				this.name = data().deepCopy(fields()[1].schema(), other.name);
				fieldSetFlags()[1] = other.fieldSetFlags()[1];
			}
		}

		/**
		 * Creates a Builder by copying an existing Account instance
		 * 
		 * @param other The existing instance to copy.
		 */
		private Builder(com.gridgain.kafka.avro.Account other) {
			super(SCHEMA$, MODEL$);
			if (isValidValue(fields()[0], other.id)) {
				this.id = data().deepCopy(fields()[0].schema(), other.id);
				fieldSetFlags()[0] = true;
			}
			if (isValidValue(fields()[1], other.name)) {
				this.name = data().deepCopy(fields()[1].schema(), other.name);
				fieldSetFlags()[1] = true;
			}
		}

		/**
		 * Gets the value of the 'id' field. Account Id
		 * 
		 * @return The value.
		 */
		public java.lang.String getId() {
			return id;
		}

		/**
		 * Sets the value of the 'id' field. Account Id
		 * 
		 * @param value The value of 'id'.
		 * @return This builder.
		 */
		public com.gridgain.kafka.avro.Account.Builder setId(java.lang.String value) {
			validate(fields()[0], value);
			this.id = value;
			fieldSetFlags()[0] = true;
			return this;
		}

		/**
		 * Checks whether the 'id' field has been set. Account Id
		 * 
		 * @return True if the 'id' field has been set, false otherwise.
		 */
		public boolean hasId() {
			return fieldSetFlags()[0];
		}

		/**
		 * Clears the value of the 'id' field. Account Id
		 * 
		 * @return This builder.
		 */
		public com.gridgain.kafka.avro.Account.Builder clearId() {
			id = null;
			fieldSetFlags()[0] = false;
			return this;
		}

		/**
		 * Gets the value of the 'name' field. Stock Name
		 * 
		 * @return The value.
		 */
		public java.lang.String getName() {
			return name;
		}

		/**
		 * Sets the value of the 'name' field. Stock Name
		 * 
		 * @param value The value of 'name'.
		 * @return This builder.
		 */
		public com.gridgain.kafka.avro.Account.Builder setName(java.lang.String value) {
			validate(fields()[1], value);
			this.name = value;
			fieldSetFlags()[1] = true;
			return this;
		}

		/**
		 * Checks whether the 'name' field has been set. Stock Name
		 * 
		 * @return True if the 'name' field has been set, false otherwise.
		 */
		public boolean hasName() {
			return fieldSetFlags()[1];
		}

		/**
		 * Clears the value of the 'name' field. Stock Name
		 * 
		 * @return This builder.
		 */
		public com.gridgain.kafka.avro.Account.Builder clearName() {
			name = null;
			fieldSetFlags()[1] = false;
			return this;
		}

		@Override
		public Account build() {
			try {
				Account record = new Account();
				record.id = fieldSetFlags()[0] ? this.id : (java.lang.String) defaultValue(fields()[0]);
				record.name = fieldSetFlags()[1] ? this.name : (java.lang.String) defaultValue(fields()[1]);
				return record;
			} catch (org.apache.avro.AvroMissingFieldException e) {
				throw e;
			} catch (java.lang.Exception e) {
				throw new org.apache.avro.AvroRuntimeException(e);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private static final org.apache.avro.io.DatumWriter<Account> WRITER$ = (org.apache.avro.io.DatumWriter<Account>) MODEL$
			.createDatumWriter(SCHEMA$);

	@Override
	public void writeExternal(java.io.ObjectOutput out) throws java.io.IOException {
		WRITER$.write(this, SpecificData.getEncoder(out));
	}

	@SuppressWarnings("unchecked")
	private static final org.apache.avro.io.DatumReader<Account> READER$ = (org.apache.avro.io.DatumReader<Account>) MODEL$
			.createDatumReader(SCHEMA$);

	@Override
	public void readExternal(java.io.ObjectInput in) throws java.io.IOException {
		READER$.read(this, SpecificData.getDecoder(in));
	}

	@Override
	protected boolean hasCustomCoders() {
		return true;
	}

	@Override
	public void customEncode(org.apache.avro.io.Encoder out) throws java.io.IOException {
		out.writeString(this.id);

		out.writeString(this.name);

	}

	@Override
	public void customDecode(org.apache.avro.io.ResolvingDecoder in) throws java.io.IOException {
		org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
		if (fieldOrder == null) {
			this.id = in.readString();

			this.name = in.readString();

		} else {
			for (int i = 0; i < 2; i++) {
				switch (fieldOrder[i].pos()) {
				case 0:
					this.id = in.readString();
					break;

				case 1:
					this.name = in.readString();
					break;

				default:
					throw new java.io.IOException("Corrupt ResolvingDecoder.");
				}
			}
		}
	}
}
