package com.database.jpa.hibernate.demo.java.general;

/**
 * @Encryption
 * 1.Encryption is a two-way function. encryption is reversible.
 *
 * Encryption is the practice of scrambling information in a way that only someone with a
 * corresponding key can unscramble and read it. Encryption is a two-way function.
 * When you encrypt something, you’re doing so with the intention of decrypting it later.
 *
 * @Examples:- AES, RSA
 *
 * @Asymmetric Encryption –
 * This is the Public Key example we just gave. One key encrypts, the other key decrypts.
 * The encryption only goes one way. This is the concept that forms the foundation for PKI (public key infrastructure),
 * which is the trust model that undergirds SSL/TLS.
 *
 * @Symmetric Encryption -
 * Uses single key for both encryption and decryption.
 *
 * @Asymmetric Encryption vs Symmetric Encryption
 * https://www.youtube.com/watch?v=z2aueocJE8Q
 *
 *
 * @Hashing
 * 1.hashing is a one-way function.
 *
 * Hashing is the practice of using an algorithm to map data of any size to a fixed length.
 * This is called a hash value (or sometimes hash code or hash sums or even a hash digest
 * if you’re feeling fancy).
 *
 * Example:- You don't want to store passwords in plain text.
 *
 * Think of it more like as an output to a very complicated algorithm which produce the
 * same garbage/output for same input.
 *
 * So if input is same then, same output will be generated. But even small change in the input
 * will generate the different output value.
 *
 * You can never go back from output to input i.e you will never be able to get input from output/hash value.
 * so it is one way function i.e Hashing is not reversible.
 *
 * You can store hash values of passwords in database and verify against it,
 * instead of storing the original passwords/plain texts.
 *
 * @Examples of hashing:-MD4, MD5,SHA
 * SHA – SHA stands for Security Hashing Algorithm  SHA-1 is now deprecated, SHA-2 is sometimes known has SHA-256
 *
 *
 * @SHA-256, that means that the algorithm is going to output a hash value that is 256 bits,
 *  usually represented by a 64 character hexadecimal string (h/t Matthew Haslett).
 *
 * Every hash value is unique. If two different files produce the same unique hash value
 *  this is called a collision and it makes the algorithm essentially useless.
 *
 *  Excellent video for Hashing
 *  https://www.youtube.com/watch?v=GI790E1JMgw
 *
 *
 *
 *  https://www.thesslstore.com/blog/difference-encryption-hashing-salting/
 *
 *
 *
 * @Encoding
 * The purpose of encoding is to transform data so that it can be properly (and safely) consumed
 * by a different type of system, e.g. binary data being sent over email, or viewing special characters
 * on a web page. The goal is not to keep information secret, but rather to ensure that it's able to
 * be properly consumed.
 *
 * Encoding transforms data into another format sing a schema that is publicly available so that
 * it can be easily reversed.
 *
 * It does not require a key as the only thing required to decode it is the algorithm
 * that was used to encode it.
 *
 * It does not require any key and we can decode it provided we know the algorithm used to encode it.
 * EG:- Base64, ASCII, unicode, URL Encoding,
 *
 *
 *
 * ****** See the diff ******
 * Encoding vs Hashing vs Encryption
 * https://www.youtube.com/watch?v=-nMOTAUSUhE
 *
 */
public class HashingVsEncryptionVsEncoding {
}
