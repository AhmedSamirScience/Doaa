package com.samirislamic.doaa._01_common._05_encryptionAndDecryptionByKeyStore.keyStoreIntegration.models

import javax.crypto.SecretKey

data class KeyModelResponse(
    val transformation: String,
    val secretKey :SecretKey
)
