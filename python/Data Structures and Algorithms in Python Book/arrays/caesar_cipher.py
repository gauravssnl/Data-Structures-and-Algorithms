class CaesarCipher:
    """Class for encryption & decryption using Caesar cipher"""

    def __init__(self, shift):
        """Construct Caeser cipher using integer shift for rotation"""
        encoder = [None] * 26
        decoder = [None] * 26
        for k in range(26):
            encoder[k] = chr((k+shift) % 26 + ord('A')) 
            decoder[k] = chr((k -shift) % 26 + ord('A'))
        self._forward = ''.join(encoder)                        # will store as string
        self._backward = ''.join(decoder)                       # use it for decoding
    
    def encrypt(self, message):
        """Return encryted message string"""
        return self._transform(message, self._forward)
    
    def decrypt(self, secret_message):
        """Return decryted message string"""
        return self._transform(secret_message, self._backward) 
    
    def _transform(self, original, code):
        msg_char_list = list(original)
        for k in range(len(msg_char_list)):
            if msg_char_list[k].isupper():
                # find index of that char of msg in the enoded/decoded char list
                j = ord(msg_char_list[k]) - ord('A')
                msg_char_list[k] = code[j]
        return ''.join(msg_char_list)
    
if __name__ == "__main__":
    caesar_cipher = CaesarCipher(shift=3)
    message = "THE EAGLE IS IN PLAY; MEET AT JOE S."
    encrypted_message = caesar_cipher.encrypt(message)
    print("Secret:", encrypted_message)
    decrypted_message = caesar_cipher.decrypt(encrypted_message)
    print("Message:", decrypted_message)

