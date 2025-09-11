package org.example;

import java.util.Objects;

public class Doctor {
    private final String id;
    private final String name;
    private final String specialty; // keep it simple for now

    public Doctor(String id, String name, String specialty) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getSpecialty() { return specialty; }

    @Override
    public String toString() {
        return "Doctor{id='%s', name='%s', specialty='%s'}".formatted(id, name, specialty);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor)) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(id, doctor.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
