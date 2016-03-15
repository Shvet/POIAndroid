/* ====================================================================
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
==================================================================== */
package com.shvet.poi.hssf.record.crypto;

import com.shvet.poi.EncryptedDocumentException;
import com.shvet.poi.hssf.usermodel.HSSFWorkbook;
import com.shvet.poi.poifs.crypt.Decryptor;

import javax.crypto.SecretKey;

public abstract class Biff8EncryptionKey {
    /**
     * Stores the BIFF8 encryption/decryption password for the current thread.  This has been done
     * using a {@link ThreadLocal} in order to avoid further overloading the various public APIs
     * (e.g. {@link HSSFWorkbook}) that need this functionality.
     */
    private static final ThreadLocal<String> _userPasswordTLS = new ThreadLocal<String>();
    protected SecretKey _secretKey;

    /**
     * Create using the default password and a specified docId
     *
     * @param salt 16 bytes
     */
    public static Biff8EncryptionKey create(byte[] salt) {
        return Biff8RC4Key.create(Decryptor.DEFAULT_PASSWORD, salt);
    }

    public static Biff8EncryptionKey create(String password, byte[] salt) {
        return Biff8RC4Key.create(password, salt);
    }

    /**
     * @return the BIFF8 encryption/decryption password for the current thread.
     * <code>null</code> if it is currently unset.
     */
    public static String getCurrentUserPassword() {
        return _userPasswordTLS.get();
    }

    /**
     * Sets the BIFF8 encryption/decryption password for the current thread.
     *
     * @param password pass <code>null</code> to clear user password (and use default)
     */
    public static void setCurrentUserPassword(String password) {
        _userPasswordTLS.set(password);
    }

    /**
     * @return <code>true</code> if the keyDigest is compatible with the specified saltData and saltHash
     */
    public boolean validate(byte[] saltData, byte[] saltHash) {
        throw new EncryptedDocumentException("validate is not supported (in super-class).");
    }
}
