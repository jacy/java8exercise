package com.rc.execise;

public class Extension {
	private String firstName;
	private String lastName;
	private String ext;
	private String extType;

	public Extension(String firstName, String lastName, String ext) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.ext = ext;
	}

	public Extension(String extType) {
		super();
		this.extType = extType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getExtType() {
		return extType;
	}

	public void setExtType(String extType) {
		this.extType = extType;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Extension other = (Extension) obj;
		if (ext == null) {
			if (other.ext != null)
				return false;
		} else if (!ext.equals(other.ext))
			return false;
		if (extType == null) {
			if (other.extType != null)
				return false;
		} else if (!extType.equals(other.extType))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
}
