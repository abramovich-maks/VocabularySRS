INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'arise', '[əˈraɪz]', 'arose', '[əˈrəʊz]', 'arisen', '[əˈrɪzn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'возникать', id FROM irregular_verb WHERE base_form='arise';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'powstawać', id FROM irregular_verb WHERE base_form='arise';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'entstehen', id FROM irregular_verb WHERE base_form='arise';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'awake', '[əˈweɪk]', 'awoke', '[əˈwəʊk]', 'awoken', '[əˈwəʊkən]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'просыпаться', id FROM irregular_verb WHERE base_form='awake';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'obudzić się', id FROM irregular_verb WHERE base_form='awake';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'aufwachen', id FROM irregular_verb WHERE base_form='awake';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'be', '[biː]', 'was/were', '[wɒz]/[wɜː]', 'been', '[biːn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'быть', id FROM irregular_verb WHERE base_form='be';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'być', id FROM irregular_verb WHERE base_form='be';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'sein', id FROM irregular_verb WHERE base_form='be';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'bear', '[beə]', 'bore', '[bɔː]', 'born/borne', '[bɔːn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'нести, терпеть, рождать', id FROM irregular_verb WHERE base_form='bear';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'znosić, nosić, rodzić', id FROM irregular_verb WHERE base_form='bear';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'tragen, ertragen, gebären', id FROM irregular_verb WHERE base_form='bear';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'beat', '[biːt]', 'beat', '[biːt]', 'beaten', '[ˈbiːtn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'бить', id FROM irregular_verb WHERE base_form='beat';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'bić', id FROM irregular_verb WHERE base_form='beat';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'schlagen', id FROM irregular_verb WHERE base_form='beat';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'become', '[bɪˈkʌm]', 'became', '[bɪˈkeɪm]', 'become', '[bɪˈkʌm]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'становиться', id FROM irregular_verb WHERE base_form='become';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'stawać się', id FROM irregular_verb WHERE base_form='become';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'werden', id FROM irregular_verb WHERE base_form='become';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'begin', '[bɪˈɡɪn]', 'began', '[bɪˈɡæn]', 'begun', '[bɪˈɡʌn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'начинать', id FROM irregular_verb WHERE base_form='begin';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'zaczynać', id FROM irregular_verb WHERE base_form='begin';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'beginnen', id FROM irregular_verb WHERE base_form='begin';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'bend', '[bend]', 'bent', '[bent]', 'bent', '[bent]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'гнуть', id FROM irregular_verb WHERE base_form='bend';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'zginać', id FROM irregular_verb WHERE base_form='bend';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'beugen', id FROM irregular_verb WHERE base_form='bend';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'bet', '[bet]', 'bet', '[bet]', 'bet', '[bet]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'спорить (на деньги)', id FROM irregular_verb WHERE base_form='bet';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'zakładać się', id FROM irregular_verb WHERE base_form='bet';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'wetten', id FROM irregular_verb WHERE base_form='bet';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'bind', '[baɪnd]', 'bound', '[baʊnd]', 'bound', '[baʊnd]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'связывать', id FROM irregular_verb WHERE base_form='bind';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'wiązać', id FROM irregular_verb WHERE base_form='bind';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'binden', id FROM irregular_verb WHERE base_form='bind';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'bite', '[baɪt]', 'bit', '[bɪt]', 'bitten', '[ˈbɪtn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'кусать', id FROM irregular_verb WHERE base_form='bite';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'gryźć', id FROM irregular_verb WHERE base_form='bite';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'beißen', id FROM irregular_verb WHERE base_form='bite';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'bleed', '[bliːd]', 'bled', '[bled]', 'bled', '[bled]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'кровоточить', id FROM irregular_verb WHERE base_form='bleed';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'krwawić', id FROM irregular_verb WHERE base_form='bleed';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'bluten', id FROM irregular_verb WHERE base_form='bleed';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'blow', '[bləʊ]', 'blew', '[bluː]', 'blown', '[bləʊn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'дуть', id FROM irregular_verb WHERE base_form='blow';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'wiać', id FROM irregular_verb WHERE base_form='blow';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'wehen', id FROM irregular_verb WHERE base_form='blow';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'break', '[breɪk]', 'broke', '[brəʊk]', 'broken', '[ˈbrəʊkən]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'ломать', id FROM irregular_verb WHERE base_form='break';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'łamać', id FROM irregular_verb WHERE base_form='break';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'brechen', id FROM irregular_verb WHERE base_form='break';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'bring', '[brɪŋ]', 'brought', '[brɔːt]', 'brought', '[brɔːt]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'приносить', id FROM irregular_verb WHERE base_form='bring';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'przynosić', id FROM irregular_verb WHERE base_form='bring';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'bringen', id FROM irregular_verb WHERE base_form='bring';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'broadcast', '[ˈbrɔːdkɑːst]', 'broadcast', '[ˈbrɔːdkɑːst]', 'broadcast', '[ˈbrɔːdkɑːst]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'вещать', id FROM irregular_verb WHERE base_form='broadcast';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'nadawać', id FROM irregular_verb WHERE base_form='broadcast';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'senden', id FROM irregular_verb WHERE base_form='broadcast';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'build', '[bɪld]', 'built', '[bɪlt]', 'built', '[bɪlt]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'строить', id FROM irregular_verb WHERE base_form='build';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'budować', id FROM irregular_verb WHERE base_form='build';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'bauen', id FROM irregular_verb WHERE base_form='build';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'burn', '[bɜːn]', 'burned/burnt', '[bɜːnd]/[bɜːnt]', 'burned/burnt', '[bɜːnd]/[bɜːnt]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'гореть', id FROM irregular_verb WHERE base_form='burn';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'palić się', id FROM irregular_verb WHERE base_form='burn';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'brennen', id FROM irregular_verb WHERE base_form='burn';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'burst', '[bɜːst]', 'burst', '[bɜːst]', 'burst', '[bɜːst]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'лопаться', id FROM irregular_verb WHERE base_form='burst';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'pękać', id FROM irregular_verb WHERE base_form='burst';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'platzen', id FROM irregular_verb WHERE base_form='burst';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'buy', '[baɪ]', 'bought', '[bɔːt]', 'bought', '[bɔːt]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'покупать', id FROM irregular_verb WHERE base_form='buy';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'kupować', id FROM irregular_verb WHERE base_form='buy';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'kaufen', id FROM irregular_verb WHERE base_form='buy';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'cast', '[kɑːst]', 'cast', '[kɑːst]', 'cast', '[kɑːst]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'бросать', id FROM irregular_verb WHERE base_form='cast';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'rzucać', id FROM irregular_verb WHERE base_form='cast';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'werfen', id FROM irregular_verb WHERE base_form='cast';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'catch', '[kætʃ]', 'caught', '[kɔːt]', 'caught', '[kɔːt]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'ловить', id FROM irregular_verb WHERE base_form='catch';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'łapać', id FROM irregular_verb WHERE base_form='catch';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'fangen', id FROM irregular_verb WHERE base_form='catch';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'choose', '[tʃuːz]', 'chose', '[tʃəʊz]', 'chosen', '[ˈtʃəʊzn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'выбирать', id FROM irregular_verb WHERE base_form='choose';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'wybierać', id FROM irregular_verb WHERE base_form='choose';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'wählen', id FROM irregular_verb WHERE base_form='choose';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'cling', '[klɪŋ]', 'clung', '[klʌŋ]', 'clung', '[klʌŋ]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'цепляться', id FROM irregular_verb WHERE base_form='cling';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'czepiać się, przylgnąć', id FROM irregular_verb WHERE base_form='cling';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'klammern', id FROM irregular_verb WHERE base_form='cling';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'come', '[kʌm]', 'came', '[keɪm]', 'come', '[kʌm]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'приходить', id FROM irregular_verb WHERE base_form='come';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'przychodzić', id FROM irregular_verb WHERE base_form='come';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'kommen', id FROM irregular_verb WHERE base_form='come';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'cost', '[kɒst]', 'cost', '[kɒst]', 'cost', '[kɒst]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'стоить', id FROM irregular_verb WHERE base_form='cost';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'kosztować', id FROM irregular_verb WHERE base_form='cost';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'kosten', id FROM irregular_verb WHERE base_form='cost';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'creep', '[kriːp]', 'crept', '[krept]', 'crept', '[krept]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'ползти', id FROM irregular_verb WHERE base_form='creep';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'pełzać', id FROM irregular_verb WHERE base_form='creep';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'kriechen', id FROM irregular_verb WHERE base_form='creep';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'cut', '[kʌt]', 'cut', '[kʌt]', 'cut', '[kʌt]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'резать', id FROM irregular_verb WHERE base_form='cut';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'ciąć', id FROM irregular_verb WHERE base_form='cut';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'schneiden', id FROM irregular_verb WHERE base_form='cut';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'deal', '[diːl]', 'dealt', '[delt]', 'dealt', '[delt]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'иметь дело с, обращаться с', id FROM irregular_verb WHERE base_form='deal';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'mieć do czynienia, zajmować się', id FROM irregular_verb WHERE base_form='deal';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'sich befassen, umgehen mit', id FROM irregular_verb WHERE base_form='deal';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'dig', '[dɪɡ]', 'dug', '[dʌɡ]', 'dug', '[dʌɡ]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'копать', id FROM irregular_verb WHERE base_form='dig';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'kopać', id FROM irregular_verb WHERE base_form='dig';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'graben', id FROM irregular_verb WHERE base_form='dig';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'do', '[duː]', 'did', '[dɪd]', 'done', '[dʌn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'делать', id FROM irregular_verb WHERE base_form='do';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'robić', id FROM irregular_verb WHERE base_form='do';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'machen', id FROM irregular_verb WHERE base_form='do';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'draw', '[drɔː]', 'drew', '[druː]', 'drawn', '[drɔːn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'рисовать', id FROM irregular_verb WHERE base_form='draw';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'rysować', id FROM irregular_verb WHERE base_form='draw';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'zeichnen', id FROM irregular_verb WHERE base_form='draw';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'dream', '[driːm]', 'dreamed/dreamt', '[driːmd]/[dremt]', 'dreamed/dreamt', '[driːmd]/[dremt]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'мечтать', id FROM irregular_verb WHERE base_form='dream';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'marzyć', id FROM irregular_verb WHERE base_form='dream';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'träumen', id FROM irregular_verb WHERE base_form='dream';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'drink', '[drɪŋk]', 'drank', '[dræŋk]', 'drunk', '[drʌŋk]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'пить', id FROM irregular_verb WHERE base_form='drink';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'pić', id FROM irregular_verb WHERE base_form='drink';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'trinken', id FROM irregular_verb WHERE base_form='drink';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'drive', '[draɪv]', 'drove', '[drəʊv]', 'driven', '[ˈdrɪvn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'водить', id FROM irregular_verb WHERE base_form='drive';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'prowadzić', id FROM irregular_verb WHERE base_form='drive';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'fahren', id FROM irregular_verb WHERE base_form='drive';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'eat', '[iːt]', 'ate', '[et]', 'eaten', '[ˈiːtn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'есть', id FROM irregular_verb WHERE base_form='eat';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'jeść', id FROM irregular_verb WHERE base_form='eat';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'essen', id FROM irregular_verb WHERE base_form='eat';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'fall', '[fɔːl]', 'fell', '[fel]', 'fallen', '[ˈfɔːlən]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'падать', id FROM irregular_verb WHERE base_form='fall';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'spadać', id FROM irregular_verb WHERE base_form='fall';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'fallen', id FROM irregular_verb WHERE base_form='fall';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'feed', '[fiːd]', 'fed', '[fed]', 'fed', '[fed]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'кормить', id FROM irregular_verb WHERE base_form='feed';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'karmić', id FROM irregular_verb WHERE base_form='feed';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'füttern', id FROM irregular_verb WHERE base_form='feed';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'feel', '[fiːl]', 'felt', '[felt]', 'felt', '[felt]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'чувствовать', id FROM irregular_verb WHERE base_form='feel';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'czuć', id FROM irregular_verb WHERE base_form='feel';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'fühlen', id FROM irregular_verb WHERE base_form='feel';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'fight', '[faɪt]', 'fought', '[fɔːt]', 'fought', '[fɔːt]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'драться', id FROM irregular_verb WHERE base_form='fight';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'walczyć', id FROM irregular_verb WHERE base_form='fight';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'kämpfen', id FROM irregular_verb WHERE base_form='fight';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'find', '[faɪnd]', 'found', '[faʊnd]', 'found', '[faʊnd]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'находить', id FROM irregular_verb WHERE base_form='find';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'znajdować', id FROM irregular_verb WHERE base_form='find';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'finden', id FROM irregular_verb WHERE base_form='find';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'fit', '[fɪt]', 'fit/fitted', '[fɪt]/[ˈfɪtɪd]', 'fit/fitted', '[fɪt]/[ˈfɪtɪd]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'подходить', id FROM irregular_verb WHERE base_form='fit';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'pasować', id FROM irregular_verb WHERE base_form='fit';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'passen', id FROM irregular_verb WHERE base_form='fit';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'flee', '[fliː]', 'fled', '[fled]', 'fled', '[fled]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'убегать', id FROM irregular_verb WHERE base_form='flee';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'uciekać', id FROM irregular_verb WHERE base_form='flee';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'fliehen', id FROM irregular_verb WHERE base_form='flee';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'fling', '[flɪŋ]', 'flung', '[flʌŋ]', 'flung', '[flʌŋ]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'швырять', id FROM irregular_verb WHERE base_form='fling';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'rzucać', id FROM irregular_verb WHERE base_form='fling';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'schleudern', id FROM irregular_verb WHERE base_form='fling';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'fly', '[flaɪ]', 'flew', '[fluː]', 'flown', '[fləʊn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'летать', id FROM irregular_verb WHERE base_form='fly';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'latać', id FROM irregular_verb WHERE base_form='fly';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'fliegen', id FROM irregular_verb WHERE base_form='fly';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'forbid', '[fəˈbɪd]', 'forbade', '[fəˈbeɪd]', 'forbidden', '[fəˈbɪdn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'запрещать', id FROM irregular_verb WHERE base_form='forbid';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'zabraniać', id FROM irregular_verb WHERE base_form='forbid';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'verbieten', id FROM irregular_verb WHERE base_form='forbid';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'forecast', '[ˈfɔːkɑːst]', 'forecast', '[ˈfɔːkɑːst]', 'forecast', '[ˈfɔːkɑːst]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'прогнозировать', id FROM irregular_verb WHERE base_form='forecast';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'prognozować', id FROM irregular_verb WHERE base_form='forecast';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'prognostizieren', id FROM irregular_verb WHERE base_form='forecast';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'foresee', '[fɔːˈsiː]', 'foresaw', '[fɔːˈsɔː]', 'foreseen', '[fɔːˈsiːn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'предвидеть', id FROM irregular_verb WHERE base_form='foresee';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'przewidywać', id FROM irregular_verb WHERE base_form='foresee';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'vorhersehen', id FROM irregular_verb WHERE base_form='foresee';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'foretell', '[fɔːˈtel]', 'foretold', '[fɔːˈtəʊld]', 'foretold', '[fɔːˈtəʊld]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'предсказывать', id FROM irregular_verb WHERE base_form='foretell';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'przepowiadać', id FROM irregular_verb WHERE base_form='foretell';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'vorhersagen', id FROM irregular_verb WHERE base_form='foretell';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'forget', '[fəˈɡet]', 'forgot', '[fəˈɡɒt]', 'forgotten', '[fəˈɡɒtn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'забывать', id FROM irregular_verb WHERE base_form='forget';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'zapominać', id FROM irregular_verb WHERE base_form='forget';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'vergessen', id FROM irregular_verb WHERE base_form='forget';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'forgive', '[fəˈɡɪv]', 'forgave', '[fəˈɡeɪv]', 'forgiven', '[fəˈɡɪvn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'прощать', id FROM irregular_verb WHERE base_form='forgive';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'wybaczać', id FROM irregular_verb WHERE base_form='forgive';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'vergeben', id FROM irregular_verb WHERE base_form='forgive';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'forsake', '[fəˈseɪk]', 'forsook', '[fəˈsʊk]', 'forsaken', '[fəˈseɪkn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'покидать', id FROM irregular_verb WHERE base_form='forsake';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'porzucać', id FROM irregular_verb WHERE base_form='forsake';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'verlassen', id FROM irregular_verb WHERE base_form='forsake';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'freeze', '[friːz]', 'froze', '[frəʊz]', 'frozen', '[ˈfrəʊzn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'замерзать', id FROM irregular_verb WHERE base_form='freeze';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'zamarzać', id FROM irregular_verb WHERE base_form='freeze';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'gefrieren', id FROM irregular_verb WHERE base_form='freeze';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'get', '[ɡet]', 'got', '[ɡɒt]', 'got/gotten', '[ɡɒt]/[ˈɡɒtn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'получать', id FROM irregular_verb WHERE base_form='get';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'dostawać', id FROM irregular_verb WHERE base_form='get';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'bekommen', id FROM irregular_verb WHERE base_form='get';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'give', '[ɡɪv]', 'gave', '[ɡeɪv]', 'given', '[ˈɡɪvn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'давать', id FROM irregular_verb WHERE base_form='give';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'dawać', id FROM irregular_verb WHERE base_form='give';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'geben', id FROM irregular_verb WHERE base_form='give';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'go', '[ɡəʊ]', 'went', '[went]', 'gone', '[ɡɒn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'идти', id FROM irregular_verb WHERE base_form='go';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'iść', id FROM irregular_verb WHERE base_form='go';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'gehen', id FROM irregular_verb WHERE base_form='go';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'grind', '[ɡraɪnd]', 'ground', '[ɡraʊnd]', 'ground', '[ɡraʊnd]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'молоть', id FROM irregular_verb WHERE base_form='grind';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'mielić', id FROM irregular_verb WHERE base_form='grind';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'mahlen', id FROM irregular_verb WHERE base_form='grind';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'grow', '[ɡrəʊ]', 'grew', '[ɡruː]', 'grown', '[ɡrəʊn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'расти', id FROM irregular_verb WHERE base_form='grow';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'rosnąć', id FROM irregular_verb WHERE base_form='grow';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'wachsen', id FROM irregular_verb WHERE base_form='grow';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'hang', '[hæŋ]', 'hung', '[hʌŋ]', 'hung', '[hʌŋ]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'висеть', id FROM irregular_verb WHERE base_form='hang';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'wisieć', id FROM irregular_verb WHERE base_form='hang';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'hängen', id FROM irregular_verb WHERE base_form='hang';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'have', '[hæv]', 'had', '[hæd]', 'had', '[hæd]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'иметь', id FROM irregular_verb WHERE base_form='have';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'mieć', id FROM irregular_verb WHERE base_form='have';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'haben', id FROM irregular_verb WHERE base_form='have';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'hear', '[hɪə]', 'heard', '[hɜːd]', 'heard', '[hɜːd]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'слышать', id FROM irregular_verb WHERE base_form='hear';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'słyszeć', id FROM irregular_verb WHERE base_form='hear';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'hören', id FROM irregular_verb WHERE base_form='hear';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'hide', '[haɪd]', 'hid', '[hɪd]', 'hidden', '[ˈhɪdn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'прятать', id FROM irregular_verb WHERE base_form='hide';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'chować', id FROM irregular_verb WHERE base_form='hide';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'verstecken', id FROM irregular_verb WHERE base_form='hide';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'hit', '[hɪt]', 'hit', '[hɪt]', 'hit', '[hɪt]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'ударять', id FROM irregular_verb WHERE base_form='hit';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'uderzać', id FROM irregular_verb WHERE base_form='hit';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'schlagen', id FROM irregular_verb WHERE base_form='hit';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'hold', '[həʊld]', 'held', '[held]', 'held', '[held]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'держать', id FROM irregular_verb WHERE base_form='hold';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'trzymać', id FROM irregular_verb WHERE base_form='hold';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'halten', id FROM irregular_verb WHERE base_form='hold';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'hurt', '[hɜːt]', 'hurt', '[hɜːt]', 'hurt', '[hɜːt]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'ранить', id FROM irregular_verb WHERE base_form='hurt';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'ranić', id FROM irregular_verb WHERE base_form='hurt';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'verletzen', id FROM irregular_verb WHERE base_form='hurt';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'keep', '[kiːp]', 'kept', '[kept]', 'kept', '[kept]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'держать', id FROM irregular_verb WHERE base_form='keep';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'trzymać', id FROM irregular_verb WHERE base_form='keep';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'behalten', id FROM irregular_verb WHERE base_form='keep';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'kneel', '[niːl]', 'knelt', '[nelt]', 'knelt', '[nelt]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'становиться на колени', id FROM irregular_verb WHERE base_form='kneel';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'klękać', id FROM irregular_verb WHERE base_form='kneel';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'knien', id FROM irregular_verb WHERE base_form='kneel';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'knit', '[nɪt]', 'knit/knitted', '[nɪt]/[ˈnɪtɪd]', 'knit/knitted', '[nɪt]/[ˈnɪtɪd]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'вязать', id FROM irregular_verb WHERE base_form='knit';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'robić na drutach', id FROM irregular_verb WHERE base_form='knit';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'stricken', id FROM irregular_verb WHERE base_form='knit';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'know', '[nəʊ]', 'knew', '[njuː]', 'known', '[nəʊn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'знать', id FROM irregular_verb WHERE base_form='know';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'wiedzieć', id FROM irregular_verb WHERE base_form='know';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'wissen', id FROM irregular_verb WHERE base_form='know';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'lay', '[leɪ]', 'laid', '[leɪd]', 'laid', '[leɪd]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'класть', id FROM irregular_verb WHERE base_form='lay';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'kłaść', id FROM irregular_verb WHERE base_form='lay';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'legen', id FROM irregular_verb WHERE base_form='lay';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'lead', '[liːd]', 'led', '[led]', 'led', '[led]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'вести', id FROM irregular_verb WHERE base_form='lead';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'prowadzić', id FROM irregular_verb WHERE base_form='lead';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'führen', id FROM irregular_verb WHERE base_form='lead';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'lean', '[liːn]', 'leaned/leant', '[liːnd]/[lent]', 'leaned/leant', '[liːnd]/[lent]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'наклоняться', id FROM irregular_verb WHERE base_form='lean';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'pochylać się', id FROM irregular_verb WHERE base_form='lean';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'lehnen', id FROM irregular_verb WHERE base_form='lean';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'leap', '[liːp]', 'leapt/leaped', '[lept]/[liːpt]', 'leapt/leaped', '[lept]/[liːpt]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'прыгать', id FROM irregular_verb WHERE base_form='leap';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'skakać', id FROM irregular_verb WHERE base_form='leap';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'springen', id FROM irregular_verb WHERE base_form='leap';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'learn', '[lɜːn]', 'learned/learnt', '[lɜːnd]/[lɜːnt]', 'learned/learnt', '[lɜːnd]/[lɜːnt]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'учить(ся)', id FROM irregular_verb WHERE base_form='learn';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'uczyć się', id FROM irregular_verb WHERE base_form='learn';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'lernen', id FROM irregular_verb WHERE base_form='learn';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'leave', '[liːv]', 'left', '[left]', 'left', '[left]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'покидать', id FROM irregular_verb WHERE base_form='leave';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'opuszczać', id FROM irregular_verb WHERE base_form='leave';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'verlassen', id FROM irregular_verb WHERE base_form='leave';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'lend', '[lend]', 'lent', '[lent]', 'lent', '[lent]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'одалживать', id FROM irregular_verb WHERE base_form='lend';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'pożyczać', id FROM irregular_verb WHERE base_form='lend';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'leihen', id FROM irregular_verb WHERE base_form='lend';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'let', '[let]', 'let', '[let]', 'let', '[let]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'позволять', id FROM irregular_verb WHERE base_form='let';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'pozwalać', id FROM irregular_verb WHERE base_form='let';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'lassen', id FROM irregular_verb WHERE base_form='let';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'lie', '[laɪ]', 'lay', '[leɪ]', 'lain', '[leɪn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'лежать', id FROM irregular_verb WHERE base_form='lie';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'leżeć', id FROM irregular_verb WHERE base_form='lie';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'liegen', id FROM irregular_verb WHERE base_form='lie';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'light', '[laɪt]', 'lit/lighted', '[lɪt]/[ˈlaɪtɪd]', 'lit/lighted', '[lɪt]/[ˈlaɪtɪd]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'зажигать', id FROM irregular_verb WHERE base_form='light';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'zapalać', id FROM irregular_verb WHERE base_form='light';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'anzünden', id FROM irregular_verb WHERE base_form='light';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'lose', '[luːz]', 'lost', '[lɒst]', 'lost', '[lɒst]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'терять', id FROM irregular_verb WHERE base_form='lose';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'tracić', id FROM irregular_verb WHERE base_form='lose';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'verlieren', id FROM irregular_verb WHERE base_form='lose';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'make', '[meɪk]', 'made', '[meɪd]', 'made', '[meɪd]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'делать', id FROM irregular_verb WHERE base_form='make';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'robić', id FROM irregular_verb WHERE base_form='make';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'machen', id FROM irregular_verb WHERE base_form='make';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'mean', '[miːn]', 'meant', '[ment]', 'meant', '[ment]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'означать', id FROM irregular_verb WHERE base_form='mean';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'oznaczać', id FROM irregular_verb WHERE base_form='mean';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'bedeuten', id FROM irregular_verb WHERE base_form='mean';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'meet', '[miːt]', 'met', '[met]', 'met', '[met]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'встречать', id FROM irregular_verb WHERE base_form='meet';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'spotykać', id FROM irregular_verb WHERE base_form='meet';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'treffen', id FROM irregular_verb WHERE base_form='meet';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'mistake', '[mɪˈsteɪk]', 'mistook', '[mɪˈstʊk]', 'mistaken', '[mɪˈsteɪkən]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'ошибаться', id FROM irregular_verb WHERE base_form='mistake';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'mylić się', id FROM irregular_verb WHERE base_form='mistake';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'irren', id FROM irregular_verb WHERE base_form='mistake';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'mow', '[məʊ]', 'mowed', '[məʊd]', 'mown/mowed', '[məʊn]/[məʊd]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'косить', id FROM irregular_verb WHERE base_form='mow';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'kosić', id FROM irregular_verb WHERE base_form='mow';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'mähen', id FROM irregular_verb WHERE base_form='mow';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'offset', '[ˌɒfˈset]', 'offset', '[ˌɒfˈset]', 'offset', '[ˌɒfˈset]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'компенсировать', id FROM irregular_verb WHERE base_form='offset';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'rekompensować', id FROM irregular_verb WHERE base_form='offset';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'ausgleichen', id FROM irregular_verb WHERE base_form='offset';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'overcome', '[ˌəʊvəˈkʌm]', 'overcame', '[ˌəʊvəˈkeɪm]', 'overcome', '[ˌəʊvəˈkʌm]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'преодолевать', id FROM irregular_verb WHERE base_form='overcome';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'pokonywać', id FROM irregular_verb WHERE base_form='overcome';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'überwinden', id FROM irregular_verb WHERE base_form='overcome';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'overhear', '[ˌəʊvəˈhɪə]', 'overheard', '[ˌəʊvəˈhɜːd]', 'overheard', '[ˌəʊvəˈhɜːd]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'подслушивать', id FROM irregular_verb WHERE base_form='overhear';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'podsłuchiwać', id FROM irregular_verb WHERE base_form='overhear';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'belauschen', id FROM irregular_verb WHERE base_form='overhear';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'oversee', '[ˌəʊvəˈsiː]', 'oversaw', '[ˌəʊvəˈsɔː]', 'overseen', '[ˌəʊvəˈsiːn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'контролировать', id FROM irregular_verb WHERE base_form='oversee';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'nadzorować', id FROM irregular_verb WHERE base_form='oversee';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'überwachen', id FROM irregular_verb WHERE base_form='oversee';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'overtake', '[ˌəʊvəˈteɪk]', 'overtook', '[ˌəʊvəˈtʊk]', 'overtaken', '[ˌəʊvəˈteɪkən]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'обгонять', id FROM irregular_verb WHERE base_form='overtake';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'wyprzedzać', id FROM irregular_verb WHERE base_form='overtake';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'überholen', id FROM irregular_verb WHERE base_form='overtake';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'overthrow', '[ˌəʊvəˈθrəʊ]', 'overthrew', '[ˌəʊvəˈθruː]', 'overthrown', '[ˌəʊvəˈθrəʊn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'свергать', id FROM irregular_verb WHERE base_form='overthrow';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'obalić', id FROM irregular_verb WHERE base_form='overthrow';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'stürzen', id FROM irregular_verb WHERE base_form='overthrow';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'pay', '[peɪ]', 'paid', '[peɪd]', 'paid', '[peɪd]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'платить', id FROM irregular_verb WHERE base_form='pay';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'płacić', id FROM irregular_verb WHERE base_form='pay';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'bezahlen', id FROM irregular_verb WHERE base_form='pay';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'prove', '[pruːv]', 'proved', '[pruːvd]', 'proven/proved', '[ˈpruːvən]/[pruːvd]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'доказывать', id FROM irregular_verb WHERE base_form='prove';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'udowadniać', id FROM irregular_verb WHERE base_form='prove';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'beweisen', id FROM irregular_verb WHERE base_form='prove';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'put', '[pʊt]', 'put', '[pʊt]', 'put', '[pʊt]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'класть', id FROM irregular_verb WHERE base_form='put';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'kłaść', id FROM irregular_verb WHERE base_form='put';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'setzen, stellen, legen', id FROM irregular_verb WHERE base_form='put';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'quit', '[kwɪt]', 'quit/quitted', '[kwɪt]/[ˈkwɪtɪd]', 'quit/quitted', '[kwɪt]/[ˈkwɪtɪd]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'бросать', id FROM irregular_verb WHERE base_form='quit';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'rzucać', id FROM irregular_verb WHERE base_form='quit';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'aufgeben', id FROM irregular_verb WHERE base_form='quit';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'read', '[riːd]', 'read', '[red]', 'read', '[red]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'читать', id FROM irregular_verb WHERE base_form='read';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'czytać', id FROM irregular_verb WHERE base_form='read';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'lesen', id FROM irregular_verb WHERE base_form='read';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'ride', '[raɪd]', 'rode', '[rəʊd]', 'ridden', '[ˈrɪdn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'ездить', id FROM irregular_verb WHERE base_form='ride';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'jeździć', id FROM irregular_verb WHERE base_form='ride';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'reiten', id FROM irregular_verb WHERE base_form='ride';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'ring', '[rɪŋ]', 'rang', '[ræŋ]', 'rung', '[rʌŋ]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'звонить', id FROM irregular_verb WHERE base_form='ring';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'dzwonić', id FROM irregular_verb WHERE base_form='ring';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'klingeln', id FROM irregular_verb WHERE base_form='ring';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'rise', '[raɪz]', 'rose', '[rəʊz]', 'risen', '[ˈrɪzn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'подниматься', id FROM irregular_verb WHERE base_form='rise';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'wzrastać', id FROM irregular_verb WHERE base_form='rise';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'steigen', id FROM irregular_verb WHERE base_form='rise';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'run', '[rʌn]', 'ran', '[ræn]', 'run', '[rʌn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'бежать', id FROM irregular_verb WHERE base_form='run';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'biec', id FROM irregular_verb WHERE base_form='run';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'laufen', id FROM irregular_verb WHERE base_form='run';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'say', '[seɪ]', 'said', '[sed]', 'said', '[sed]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'говорить', id FROM irregular_verb WHERE base_form='say';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'mówić', id FROM irregular_verb WHERE base_form='say';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'sagen', id FROM irregular_verb WHERE base_form='say';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'see', '[siː]', 'saw', '[sɔː]', 'seen', '[siːn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'видеть', id FROM irregular_verb WHERE base_form='see';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'widzieć', id FROM irregular_verb WHERE base_form='see';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'sehen', id FROM irregular_verb WHERE base_form='see';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'seek', '[siːk]', 'sought', '[sɔːt]', 'sought', '[sɔːt]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'искать', id FROM irregular_verb WHERE base_form='seek';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'szukać', id FROM irregular_verb WHERE base_form='seek';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'suchen', id FROM irregular_verb WHERE base_form='seek';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'sell', '[sel]', 'sold', '[səʊld]', 'sold', '[səʊld]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'продавать', id FROM irregular_verb WHERE base_form='sell';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'sprzedawać', id FROM irregular_verb WHERE base_form='sell';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'verkaufen', id FROM irregular_verb WHERE base_form='sell';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'send', '[send]', 'sent', '[sent]', 'sent', '[sent]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'отправлять', id FROM irregular_verb WHERE base_form='send';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'wysyłać', id FROM irregular_verb WHERE base_form='send';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'senden', id FROM irregular_verb WHERE base_form='send';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'set', '[set]', 'set', '[set]', 'set', '[set]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'устанавливать', id FROM irregular_verb WHERE base_form='set';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'ustawiać', id FROM irregular_verb WHERE base_form='set';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'setzen', id FROM irregular_verb WHERE base_form='set';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'sew', '[səʊ]', 'sewed', '[səʊd]', 'sewn/sewed', '[səʊn]/[səʊd]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'шить', id FROM irregular_verb WHERE base_form='sew';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'szyć', id FROM irregular_verb WHERE base_form='sew';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'nähen', id FROM irregular_verb WHERE base_form='sew';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'shake', '[ʃeɪk]', 'shook', '[ʃʊk]', 'shaken', '[ˈʃeɪkən]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'трясти', id FROM irregular_verb WHERE base_form='shake';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'trząść', id FROM irregular_verb WHERE base_form='shake';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'schütteln', id FROM irregular_verb WHERE base_form='shake';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'shave', '[ʃeɪv]', 'shaved', '[ʃeɪvd]', 'shaved/shaven', '[ʃeɪvd]/[ˈʃeɪvən]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'брить', id FROM irregular_verb WHERE base_form='shave';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'golić', id FROM irregular_verb WHERE base_form='shave';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'rasieren', id FROM irregular_verb WHERE base_form='shave';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'shear', '[ʃɪə]', 'sheared', '[ʃɪəd]', 'sheared/shorn', '[ʃɪəd]/[ʃɔːn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'стричь', id FROM irregular_verb WHERE base_form='shear';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'strzyc', id FROM irregular_verb WHERE base_form='shear';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'scheren', id FROM irregular_verb WHERE base_form='shear';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'shed', '[ʃed]', 'shed', '[ʃed]', 'shed', '[ʃed]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'проливать, сбрасывать', id FROM irregular_verb WHERE base_form='shed';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'rozlewać, zrzucać', id FROM irregular_verb WHERE base_form='shed';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'vergießen, verlieren, abwerfen', id FROM irregular_verb WHERE base_form='shed';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'shine', '[ʃaɪn]', 'shone', '[ʃəʊn]', 'shone', '[ʃəʊn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'сиять', id FROM irregular_verb WHERE base_form='shine';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'świecić', id FROM irregular_verb WHERE base_form='shine';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'scheinen', id FROM irregular_verb WHERE base_form='shine';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'shoot', '[ʃuːt]', 'shot', '[ʃɒt]', 'shot', '[ʃɒt]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'стрелять', id FROM irregular_verb WHERE base_form='shoot';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'strzelać', id FROM irregular_verb WHERE base_form='shoot';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'schießen', id FROM irregular_verb WHERE base_form='shoot';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'show', '[ʃəʊ]', 'showed', '[ʃəʊd]', 'shown/showed', '[ʃəʊn]/[ʃəʊd]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'показывать', id FROM irregular_verb WHERE base_form='show';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'pokazywać', id FROM irregular_verb WHERE base_form='show';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'zeigen', id FROM irregular_verb WHERE base_form='show';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'shrink', '[ʃrɪŋk]', 'shrank', '[ʃræŋk]', 'shrunk', '[ʃrʌŋk]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'сжиматься', id FROM irregular_verb WHERE base_form='shrink';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'kurczyć się', id FROM irregular_verb WHERE base_form='shrink';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'schrumpfen', id FROM irregular_verb WHERE base_form='shrink';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'shut', '[ʃʌt]', 'shut', '[ʃʌt]', 'shut', '[ʃʌt]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'закрывать', id FROM irregular_verb WHERE base_form='shut';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'zamykać', id FROM irregular_verb WHERE base_form='shut';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'schließen', id FROM irregular_verb WHERE base_form='shut';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'sing', '[sɪŋ]', 'sang', '[sæŋ]', 'sung', '[sʌŋ]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'петь', id FROM irregular_verb WHERE base_form='sing';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'śpiewać', id FROM irregular_verb WHERE base_form='sing';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'singen', id FROM irregular_verb WHERE base_form='sing';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'sink', '[sɪŋk]', 'sank', '[sæŋk]', 'sunk', '[sʌŋk]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'тонуть', id FROM irregular_verb WHERE base_form='sink';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'tonąć', id FROM irregular_verb WHERE base_form='sink';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'sinken', id FROM irregular_verb WHERE base_form='sink';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'sit', '[sɪt]', 'sat', '[sæt]', 'sat', '[sæt]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'сидеть', id FROM irregular_verb WHERE base_form='sit';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'siedzieć', id FROM irregular_verb WHERE base_form='sit';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'sitzen', id FROM irregular_verb WHERE base_form='sit';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'sleep', '[sliːp]', 'slept', '[slept]', 'slept', '[slept]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'спать', id FROM irregular_verb WHERE base_form='sleep';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'spać', id FROM irregular_verb WHERE base_form='sleep';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'schlafen', id FROM irregular_verb WHERE base_form='sleep';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'slide', '[slaɪd]', 'slid', '[slɪd]', 'slid', '[slɪd]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'скользить', id FROM irregular_verb WHERE base_form='slide';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'ślizgać się', id FROM irregular_verb WHERE base_form='slide';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'rutschen', id FROM irregular_verb WHERE base_form='slide';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'sling', '[slɪŋ]', 'slung', '[slʌŋ]', 'slung', '[slʌŋ]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'швырять', id FROM irregular_verb WHERE base_form='sling';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'rzucać', id FROM irregular_verb WHERE base_form='sling';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'schleudern', id FROM irregular_verb WHERE base_form='sling';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'slink', '[slɪŋk]', 'slinked/slunk', '[slɪŋkt]/[slʌŋk]', 'slinked/slunk', '[slɪŋkt]/[slʌŋk]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'красться', id FROM irregular_verb WHERE base_form='slink';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'skradać się', id FROM irregular_verb WHERE base_form='slink';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'schleichen', id FROM irregular_verb WHERE base_form='slink';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'slit', '[slɪt]', 'slit', '[slɪt]', 'slit', '[slɪt]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'разрезать', id FROM irregular_verb WHERE base_form='slit';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'rozciąć', id FROM irregular_verb WHERE base_form='slit';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'aufschlitzen', id FROM irregular_verb WHERE base_form='slit';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'smell', '[smel]', 'smelled/smelt', '[smeld]/[smelt]', 'smelled/smelt', '[smeld]/[smelt]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'пахнуть', id FROM irregular_verb WHERE base_form='smell';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'pachnieć', id FROM irregular_verb WHERE base_form='smell';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'riechen', id FROM irregular_verb WHERE base_form='smell';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'sow', '[səʊ]', 'sowed', '[səʊd]', 'sown/sowed', '[səʊn]/[səʊd]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'сеять', id FROM irregular_verb WHERE base_form='sow';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'siać', id FROM irregular_verb WHERE base_form='sow';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'säen', id FROM irregular_verb WHERE base_form='sow';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'speak', '[spiːk]', 'spoke', '[spəʊk]', 'spoken', '[ˈspəʊkən]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'говорить', id FROM irregular_verb WHERE base_form='speak';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'mówić', id FROM irregular_verb WHERE base_form='speak';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'sprechen', id FROM irregular_verb WHERE base_form='speak';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'speed', '[spiːd]', 'sped/speeded', '[sped]/[ˈspiːdɪd]', 'sped/speeded', '[sped]/[ˈspiːdɪd]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'ускорять', id FROM irregular_verb WHERE base_form='speed';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'przyspieszać', id FROM irregular_verb WHERE base_form='speed';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'beschleunigen', id FROM irregular_verb WHERE base_form='speed';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'spell', '[spel]', 'spelled/spelt', '[speld]/[spelt]', 'spelled/spelt', '[speld]/[spelt]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'произносить по буквам', id FROM irregular_verb WHERE base_form='spell';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'literować', id FROM irregular_verb WHERE base_form='spell';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'buchstabieren', id FROM irregular_verb WHERE base_form='spell';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'spend', '[spend]', 'spent', '[spent]', 'spent', '[spent]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'тратить', id FROM irregular_verb WHERE base_form='spend';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'wydawać', id FROM irregular_verb WHERE base_form='spend';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'ausgeben', id FROM irregular_verb WHERE base_form='spend';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'spill', '[spɪl]', 'spilled/spilt', '[spɪld]/[spɪlt]', 'spilled/spilt', '[spɪld]/[spɪlt]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'проливать', id FROM irregular_verb WHERE base_form='spill';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'rozlewać', id FROM irregular_verb WHERE base_form='spill';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'verschütten', id FROM irregular_verb WHERE base_form='spill';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'spin', '[spɪn]', 'spun', '[spʌn]', 'spun', '[spʌn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'крутить', id FROM irregular_verb WHERE base_form='spin';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'kręcić', id FROM irregular_verb WHERE base_form='spin';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'drehen', id FROM irregular_verb WHERE base_form='spin';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'spit', '[spɪt]', 'spit/spat', '[spɪt]/[spæt]', 'spit/spat', '[spɪt]/[spæt]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'плевать', id FROM irregular_verb WHERE base_form='spit';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'pluć', id FROM irregular_verb WHERE base_form='spit';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'spucken', id FROM irregular_verb WHERE base_form='spit';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'split', '[splɪt]', 'split', '[splɪt]', 'split', '[splɪt]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'разделять', id FROM irregular_verb WHERE base_form='split';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'dzielić', id FROM irregular_verb WHERE base_form='split';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'teilen', id FROM irregular_verb WHERE base_form='split';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'spoil', '[spɔɪl]', 'spoiled/spoilt', '[spɔɪld]/[spɔɪlt]', 'spoiled/spoilt', '[spɔɪld]/[spɔɪlt]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'портить', id FROM irregular_verb WHERE base_form='spoil';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'psuć', id FROM irregular_verb WHERE base_form='spoil';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'verderben', id FROM irregular_verb WHERE base_form='spoil';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'spread', '[spred]', 'spread', '[spred]', 'spread', '[spred]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'распространять', id FROM irregular_verb WHERE base_form='spread';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'rozprzestrzeniać', id FROM irregular_verb WHERE base_form='spread';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'verbreiten', id FROM irregular_verb WHERE base_form='spread';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'spring', '[sprɪŋ]', 'sprang', '[spræŋ]', 'sprung', '[sprʌŋ]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'прыгать', id FROM irregular_verb WHERE base_form='spring';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'skakać', id FROM irregular_verb WHERE base_form='spring';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'springen', id FROM irregular_verb WHERE base_form='spring';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'stand', '[stænd]', 'stood', '[stʊd]', 'stood', '[stʊd]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'стоять', id FROM irregular_verb WHERE base_form='stand';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'stać', id FROM irregular_verb WHERE base_form='stand';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'stehen', id FROM irregular_verb WHERE base_form='stand';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'steal', '[stiːl]', 'stole', '[stəʊl]', 'stolen', '[ˈstəʊlən]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'красть', id FROM irregular_verb WHERE base_form='steal';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'ukraść', id FROM irregular_verb WHERE base_form='steal';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'stehlen', id FROM irregular_verb WHERE base_form='steal';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'stick', '[stɪk]', 'stuck', '[stʌk]', 'stuck', '[stʌk]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'прилипать', id FROM irregular_verb WHERE base_form='stick';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'przyklejać się', id FROM irregular_verb WHERE base_form='stick';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'kleben', id FROM irregular_verb WHERE base_form='stick';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'sting', '[stɪŋ]', 'stung', '[stʌŋ]', 'stung', '[stʌŋ]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'жалить', id FROM irregular_verb WHERE base_form='sting';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'żąglić', id FROM irregular_verb WHERE base_form='sting';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'stechen', id FROM irregular_verb WHERE base_form='sting';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'stink', '[stɪŋk]', 'stank', '[stæŋk]', 'stunk', '[stʌŋk]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'вонять', id FROM irregular_verb WHERE base_form='stink';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'śmierdzieć', id FROM irregular_verb WHERE base_form='stink';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'stinken', id FROM irregular_verb WHERE base_form='stink';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'strike', '[straɪk]', 'struck', '[strʌk]', 'struck/stricken', '[strʌk]/[ˈstrɪkən]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'ударять', id FROM irregular_verb WHERE base_form='strike';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'uderzać', id FROM irregular_verb WHERE base_form='strike';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'schlagen', id FROM irregular_verb WHERE base_form='strike';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'stride', '[straɪd]', 'strode', '[strəʊd]', 'stridden', '[ˈstrɪdn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'шагать', id FROM irregular_verb WHERE base_form='stride';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'kroczyć', id FROM irregular_verb WHERE base_form='stride';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'schreiten', id FROM irregular_verb WHERE base_form='stride';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'strive', '[straɪv]', 'strove/strived', '[strəʊv]/[straɪvd]', 'striven/strived', '[ˈstrɪvn]/[straɪvd]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'стремиться', id FROM irregular_verb WHERE base_form='strive';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'dążyć', id FROM irregular_verb WHERE base_form='strive';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'streben', id FROM irregular_verb WHERE base_form='strive';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'swear', '[sweə]', 'swore', '[swɔː]', 'sworn', '[swɔːn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'клясться', id FROM irregular_verb WHERE base_form='swear';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'przysięgać', id FROM irregular_verb WHERE base_form='swear';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'schwören', id FROM irregular_verb WHERE base_form='swear';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'sweep', '[swiːp]', 'swept', '[swept]', 'swept', '[swept]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'подметать', id FROM irregular_verb WHERE base_form='sweep';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'zamiatać', id FROM irregular_verb WHERE base_form='sweep';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'fegen', id FROM irregular_verb WHERE base_form='sweep';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'swell', '[swel]', 'swelled', '[sweld]', 'swollen/swelled', '[ˈswəʊlən]/[sweld]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'распухать', id FROM irregular_verb WHERE base_form='swell';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'puchnąć', id FROM irregular_verb WHERE base_form='swell';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'anschwellen', id FROM irregular_verb WHERE base_form='swell';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'swim', '[swɪm]', 'swam', '[swæm]', 'swum', '[swʌm]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'плавать', id FROM irregular_verb WHERE base_form='swim';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'pływać', id FROM irregular_verb WHERE base_form='swim';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'schwimmen', id FROM irregular_verb WHERE base_form='swim';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'swing', '[swɪŋ]', 'swung', '[swʌŋ]', 'swung', '[swʌŋ]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'качаться', id FROM irregular_verb WHERE base_form='swing';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'huśtać się', id FROM irregular_verb WHERE base_form='swing';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'schwingen', id FROM irregular_verb WHERE base_form='swing';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'take', '[teɪk]', 'took', '[tʊk]', 'taken', '[ˈteɪkən]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'брать', id FROM irregular_verb WHERE base_form='take';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'brać', id FROM irregular_verb WHERE base_form='take';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'nehmen', id FROM irregular_verb WHERE base_form='take';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'teach', '[tiːtʃ]', 'taught', '[tɔːt]', 'taught', '[tɔːt]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'учить', id FROM irregular_verb WHERE base_form='teach';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'nauczać', id FROM irregular_verb WHERE base_form='teach';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'unterrichten', id FROM irregular_verb WHERE base_form='teach';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'tear', '[teə]', 'tore', '[tɔː]', 'torn', '[tɔːn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'рвать', id FROM irregular_verb WHERE base_form='tear';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'rwać', id FROM irregular_verb WHERE base_form='tear';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'reißen', id FROM irregular_verb WHERE base_form='tear';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'tell', '[tel]', 'told', '[təʊld]', 'told', '[təʊld]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'рассказывать', id FROM irregular_verb WHERE base_form='tell';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'opowiadać', id FROM irregular_verb WHERE base_form='tell';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'erzählen', id FROM irregular_verb WHERE base_form='tell';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'think', '[θɪŋk]', 'thought', '[θɔːt]', 'thought', '[θɔːt]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'думать', id FROM irregular_verb WHERE base_form='think';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'myśleć', id FROM irregular_verb WHERE base_form='think';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'denken', id FROM irregular_verb WHERE base_form='think';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'throw', '[θrəʊ]', 'threw', '[θruː]', 'thrown', '[θrəʊn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'бросать', id FROM irregular_verb WHERE base_form='throw';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'rzucać', id FROM irregular_verb WHERE base_form='throw';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'werfen', id FROM irregular_verb WHERE base_form='throw';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'thrust', '[θrʌst]', 'thrust', '[θrʌst]', 'thrust', '[θrʌst]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'толкать', id FROM irregular_verb WHERE base_form='thrust';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'pchać', id FROM irregular_verb WHERE base_form='thrust';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'stoßen', id FROM irregular_verb WHERE base_form='thrust';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'tread', '[tred]', 'trod', '[trɒd]', 'trodden', '[ˈtrɒdn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'ступать', id FROM irregular_verb WHERE base_form='tread';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'stąpać', id FROM irregular_verb WHERE base_form='tread';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'treten', id FROM irregular_verb WHERE base_form='tread';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'undergo', '[ˌʌndəˈɡəʊ]', 'underwent', '[ˌʌndəˈwent]', 'undergone', '[ˌʌndəˈɡɒn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'подвергаться', id FROM irregular_verb WHERE base_form='undergo';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'podlegać', id FROM irregular_verb WHERE base_form='undergo';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'durchlaufen', id FROM irregular_verb WHERE base_form='undergo';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'understand', '[ˌʌndəˈstænd]', 'understood', '[ˌʌndəˈstʊd]', 'understood', '[ˌʌndəˈstʊd]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'понимать', id FROM irregular_verb WHERE base_form='understand';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'rozumieć', id FROM irregular_verb WHERE base_form='understand';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'verstehen', id FROM irregular_verb WHERE base_form='understand';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'undertake', '[ˌʌndəˈteɪk]', 'undertook', '[ˌʌndəˈtʊk]', 'undertaken', '[ˌʌndəˈteɪkən]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'предпринимать', id FROM irregular_verb WHERE base_form='undertake';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'podejmować', id FROM irregular_verb WHERE base_form='undertake';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'unternehmen', id FROM irregular_verb WHERE base_form='undertake';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'undo', '[ʌnˈduː]', 'undid', '[ʌnˈdɪd]', 'undone', '[ʌnˈdʌn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'отменять', id FROM irregular_verb WHERE base_form='undo';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'cofać', id FROM irregular_verb WHERE base_form='undo';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'rückgängig machen', id FROM irregular_verb WHERE base_form='undo';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'upset', '[ʌpˈset]', 'upset', '[ʌpˈset]', 'upset', '[ʌpˈset]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'расстраивать', id FROM irregular_verb WHERE base_form='upset';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'denerwować', id FROM irregular_verb WHERE base_form='upset';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'verärgern', id FROM irregular_verb WHERE base_form='upset';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'wake', '[weɪk]', 'woke/waked', '[wəʊk]/[weɪkt]', 'woken/waked', '[ˈwəʊkən]/[weɪkt]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'просыпаться', id FROM irregular_verb WHERE base_form='wake';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'budzić się', id FROM irregular_verb WHERE base_form='wake';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'aufwachen', id FROM irregular_verb WHERE base_form='wake';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'wear', '[weə]', 'wore', '[wɔː]', 'worn', '[wɔːn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'носить', id FROM irregular_verb WHERE base_form='wear';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'nosić', id FROM irregular_verb WHERE base_form='wear';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'tragen', id FROM irregular_verb WHERE base_form='wear';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'weave', '[wiːv]', 'wove/weaved', '[wəʊv]/[wiːvd]', 'woven/weaved', '[ˈwəʊvn]/[wiːvd]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'ткать', id FROM irregular_verb WHERE base_form='weave';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'tkać', id FROM irregular_verb WHERE base_form='weave';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'weben', id FROM irregular_verb WHERE base_form='weave';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'weep', '[wiːp]', 'wept', '[wept]', 'wept', '[wept]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'плакать', id FROM irregular_verb WHERE base_form='weep';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'płakać', id FROM irregular_verb WHERE base_form='weep';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'weinen', id FROM irregular_verb WHERE base_form='weep';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'win', '[wɪn]', 'won', '[wʌn]', 'won', '[wʌn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'выигрывать', id FROM irregular_verb WHERE base_form='win';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'wygrywać', id FROM irregular_verb WHERE base_form='win';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'gewinnen', id FROM irregular_verb WHERE base_form='win';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'wind', '[waɪnd]', 'wound', '[waʊnd]', 'wound', '[waʊnd]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'наматывать', id FROM irregular_verb WHERE base_form='wind';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'nawijać', id FROM irregular_verb WHERE base_form='wind';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'winden', id FROM irregular_verb WHERE base_form='wind';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'withdraw', '[wɪðˈdrɔː]', 'withdrew', '[wɪðˈdruː]', 'withdrawn', '[wɪðˈdrɔːn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'отзывать', id FROM irregular_verb WHERE base_form='withdraw';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'wycofywać', id FROM irregular_verb WHERE base_form='withdraw';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'zurückziehen', id FROM irregular_verb WHERE base_form='withdraw';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'withhold', '[wɪðˈhəʊld]', 'withheld', '[wɪðˈheld]', 'withheld', '[wɪðˈheld]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'удерживать', id FROM irregular_verb WHERE base_form='withhold';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'wstrzymywać', id FROM irregular_verb WHERE base_form='withhold';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'zurückhalten', id FROM irregular_verb WHERE base_form='withhold';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'withstand', '[wɪðˈstænd]', 'withstood', '[wɪðˈstʊd]', 'withstood', '[wɪðˈstʊd]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'противостоять', id FROM irregular_verb WHERE base_form='withstand';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'oprzeć się', id FROM irregular_verb WHERE base_form='withstand';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'widerstehen', id FROM irregular_verb WHERE base_form='withstand';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'wring', '[rɪŋ]', 'wrung', '[rʌŋ]', 'wrung', '[rʌŋ]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'выкручивать', id FROM irregular_verb WHERE base_form='wring';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'wykręcać', id FROM irregular_verb WHERE base_form='wring';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'auswringen', id FROM irregular_verb WHERE base_form='wring';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'write', '[raɪt]', 'wrote', '[rəʊt]', 'written', '[ˈrɪtn]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'писать', id FROM irregular_verb WHERE base_form='write';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'pisać', id FROM irregular_verb WHERE base_form='write';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'schreiben', id FROM irregular_verb WHERE base_form='write';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'can', '[kæn]', 'could', '[kʊd]', '—', '[—]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'мочь', id FROM irregular_verb WHERE base_form='can';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'móc', id FROM irregular_verb WHERE base_form='can';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'können', id FROM irregular_verb WHERE base_form='can';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'may', '[meɪ]', 'might', '[maɪt]', '—', '[—]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'мочь', id FROM irregular_verb WHERE base_form='may';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'móc', id FROM irregular_verb WHERE base_form='may';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'dürfen', id FROM irregular_verb WHERE base_form='may';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'must', '[mʌst]', '—', '[—]', '—', '[—]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'должен', id FROM irregular_verb WHERE base_form='must';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'musieć', id FROM irregular_verb WHERE base_form='must';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'müssen', id FROM irregular_verb WHERE base_form='must';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'shall', '[ʃæl]', 'should', '[ʃʊd]', '—', '[—]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'следует', id FROM irregular_verb WHERE base_form='shall';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'powinien', id FROM irregular_verb WHERE base_form='shall';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'sollen', id FROM irregular_verb WHERE base_form='shall';

INSERT INTO irregular_verb (id, base_form, base_transcription, past_simple, past_transcription, past_participle, past_participle_transcription) VALUES (nextval('irregular_verb_id_seq'), 'will', '[wɪl]', 'would', '[wʊd]', '—', '[—]');
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'RU', 'будет', id FROM irregular_verb WHERE base_form='will';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'PL', 'będzie', id FROM irregular_verb WHERE base_form='will';
INSERT INTO irregular_verb_translation (id, language, translation, verb_id) SELECT nextval('irregular_verb_translation_id_seq'), 'DE', 'werden', id FROM irregular_verb WHERE base_form='will';
