from arraystack import ArrayStack

def is_matched_html(raw_html:str):
    """Returns True if all HTML tags are properly matched; False otherwise"""
    S = ArrayStack()
    j = raw_html.find("<")              # find first '<' char (if any)
    while j != -1:                      # find() returns -1 if it fails 
        k = raw_html.find(">", j+1)     # find next '>' char if any 
        if k == -1:
            return False
        tag = raw_html[j+1: k]          # remove '<>' 
        
        if not tag.startswith('/'):     # opening tag
            S.push(tag)
        else:                           # closing tag
            if S.is_empty():            
                return False            # nothing to match with
            if tag[1:] != S.pop():      # remove '/' from closing tag and match with opening tag stored in stack
                return False
        
        j = raw_html.find('<', k+1)  # find the next '<' char (if any) for next tag
    
    return S.is_empty()                  # were all tags were matched, then stack should be empty?

if __name__ == "__main__":
    raw_html_data = '<html><head></head></html>'   
    print(is_matched_html(raw_html_data))

    raw_html_data = '<html><head><head><html>'   
    print(is_matched_html(raw_html_data))           


