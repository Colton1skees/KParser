grammar KG;

// parser rules
NUMBER: [0-9]+ ;

lit_rh: '"%ah"'
              | '"%bh"'
              | '"%ch"'
              | '"%dh"';
lit_r8:
 '"%al"'
              | '"%bl"'
              | '"%cl"'
              | '"%dl"'
              | '"%sil"'
              | '"%dil"'
              | '"%spl"'
              | '"%bpl"'
              | '"%r8b"'
              | '"%r9b"'
              | '"%r10b"'
              | '"%r11b"'
              | '"%r12b"'
              | '"%r13b"'
              | '"%r14b"'
              | '"%r15b"';
lit_r16: '"%ax"'
               | '"%bx"'
               | '"%cx"'
               | '"%dx"'
               | '"%si"'
               | '"%di"'
               | '"%sp"'
               | '"%bp"'
               | '"%r8w"'
               | '"%r9w"'
               | '"%r10w"'
               | '"%r11w"'
               | '"%r12w"'
               | '"%r13w"'
               | '"%r14w"'
               | '"%r15w"';
lit_r32:  '"%eax"'
               | '"%ebx"'
               | '"%ecx"'
               | '"%edx"'
               | '"%esi"'
               | '"%edi"'
               | '"%esp"'
               | '"%ebp"'
               | '"%r8d"'
               | '"%r9d"'
               | '"%r10d"'
               | '"%r11d"'
               | '"%r12d"'
               | '"%r13d"'
               | '"%r14d"'
               | '"%r15d"';
lit_r64:  '"%rax"'
               | '"%rbx"'
               | '"%rcx"'
               | '"%rdx"'
               | '"%rsi"'
               | '"%rdi"'
               | '"%rsp"'
               | '"%rbp"'
               | '"%r8"'
               | '"%r9"'
               | '"%r10"'
               | '"%r11"'
               | '"%r12"'
               | '"%r13"'
               | '"%r14"'
               | '"%r15"';

lit_sreg: '"%es"'
                | '"%cs"'
                | '"%ss"'
                | '"%ds"'
                | '"%fs"'
                | '"%gs"';

lit_st: '"%st"'
              | '"%st(0)"'
              | '"%st(1)"'
              | '"%st(2)"'
              | '"%st(3)"'
              | '"%st(4)"'
              | '"%st(5)"'
              | '"%st(6)"'
              | '"%st(7)"';

lit_xmm: '"%xmm0"'
               | '"%xmm1"'
               | '"%xmm2"'
               | '"%xmm3"'
               | '"%xmm4"'
               | '"%xmm5"'
               | '"%xmm6"'
               | '"%xmm7"'
               | '"%xmm8"'
               | '"%xmm9"'
               | '"%xmm10"'
               | '"%xmm11"'
               | '"%xmm12"'
               | '"%xmm13"'
               | '"%xmm14"'
               | '"%xmm15"';

lit_mm: '"%mmx0"'
               | '"%mmx1"'
               | '"%mmx2"'
               | '"%mmx3"'
               | '"%mmx4"'
               | '"%mmx5"'
               | '"%mmx6"'
               | '"%mmx7"';

lit_ymm: '"%ymm0"'
               | '"%ymm1"'
               | '"%ymm2"'
               | '"%ymm3"'
               | '"%ymm4"'
               | '"%ymm5"'
               | '"%ymm6"'
               | '"%ymm7"'
               | '"%ymm8"'
               | '"%ymm9"'
               | '"%ymm10"'
               | '"%ymm11"'
               | '"%ymm12"'
               | '"%ymm13"'
               | '"%ymm14"'
               | '"%ymm15"';

lit_reg:
    lit_rh
    | lit_r8
    | lit_r16
    | lit_r32
    | lit_r64
    | lit_sreg
    | lit_st
    | lit_xmm
    | lit_mm
    | lit_ymm;

operand:
    R1
    | R2
    | R3
    ;

function:
    GETPARENTVALUE
    | EXTRACTMINT
    | CONCATENATEMINT
    | MI
    | ADDMINT
    ;

functionCall: function LPARAM ((functionCall | NUMBER | lit_reg | operand | RSMAP) Comma)+ RPARAM;

// lexer rules:

// Punctuation
WHITESPACE: ' ' -> skip;
LPARAM: '(';
RPARAM: ')';
Comma: ',';

// Functions
GETPARENTVALUE: 'getParentValue';
EXTRACTMINT: 'extractMInt';
CONCATENATEMINT: 'concatenateMInt';
MI: 'mi';
ADDMINT: 'addMInt';
ANDMINT: 'andMInt';

// Operands:
R1: 'R1';
R2: 'R2';
R3: 'R3';

RSMAP: 'RSMap';

// Unique Parameters


// Registers
//RH: 'EXAMPLE';
//R8: 'EXAMPLE';
//R16: 'EXAMPLE';
//R32: 'EXAMPLE';
//R64: 'EXAMPLE';
//Xmm: 'EXAMPLE';
//Ymm: 'EXAMPLE';
//MM: 'EXAMPLE';





// EXAMPLE: 'EXAMPLE';  