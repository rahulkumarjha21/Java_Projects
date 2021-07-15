import spacy
from text_input import sentences

nlp=spacy.load('bengali_core');

print('Tokenization')
for sentence in sentences:
    doc=nlp(sentence)
    for token in doc:
        print(token)
    print('-------------------')

print('Entity Ruler')
for sentence in sentences:
    doc=nlp(sentence)
    for ent in doc.ents:
        print(ent.text,ent.label_)
    print('-------------------')
    
print(nlp.pipe_names)
