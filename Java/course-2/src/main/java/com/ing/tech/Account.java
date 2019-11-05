package com.ing.tech;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {
        private String accountNumber;
        private String PIN;
        private long balance;

        protected boolean canEqual(Object other) {
                return other instanceof Account;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof Account)) return false;
            Account other = (Account) o;
            if (!other.canEqual((Object)this)) return false;
            if (!this.accountNumber.equals(((Account) o).accountNumber)) return false;
            if (!this.PIN.equals(((Account) o).PIN)) return false;
            return true;
        }

        @Override public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            final long temp1 = Integer.parseInt(accountNumber);
            result = (result*PRIME) + (this.PIN == null ? 43 : this.PIN.hashCode());
            result = (result*PRIME) + (int)(temp1 ^ (temp1 >>> 32));
            return result;
        }
}
