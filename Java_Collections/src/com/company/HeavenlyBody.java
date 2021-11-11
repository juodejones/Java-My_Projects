package com.company;

import java.security.Key;
import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {

    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public enum BodyType { //BODY TYPE OF ALL HEAVENLY BODIES
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        ASTEROID,
        MANMADE
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyType bodyType) {

        this.key = makeKey(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public Key getKey() {
        return key;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSatellite(HeavenlyBody satellite) {
        return this.satellites.add(satellite);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    public static Key makeKey(String name, BodyType bodyType) {
        return new Key(name, bodyType);
    }


    @Override
    public final boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if( obj instanceof HeavenlyBody){
            HeavenlyBody heavenlyBody = ((HeavenlyBody)obj);
            return this.key.equals(heavenlyBody.getKey());
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.key.hashCode();
    }

    @Override
    public String toString() {
        return this.key.toString() + ", " + this.orbitalPeriod;
    }

    public  static final class Key{

        private final String name;
        private final BodyType bodyType;

        public Key(String name, BodyType bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyType getBodyType() {
            return bodyType;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 1 + this.bodyType.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if (this.name.equals(key.getName())) {
                return this.bodyType == key.bodyType;
            }
            return false;
        }

        @Override
        public String toString() {
            String name = this.name;
            if (name.length() < 8) {
                int size = 8 - name.length();
                for (int i = 0; i < size; i ++) {
                    name += " ";
                }
            }
            return "\t" + name + " : " + this.bodyType.name() ;
        }
    }
}
