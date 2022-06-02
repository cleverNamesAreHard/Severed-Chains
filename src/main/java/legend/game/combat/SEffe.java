package legend.game.combat;

import legend.core.gte.GsCOORDINATE2;
import legend.core.gte.MATRIX;
import legend.core.gte.SVECTOR;
import legend.core.gte.VECTOR;
import legend.core.memory.Memory;
import legend.core.memory.Method;
import legend.core.memory.Ref;
import legend.core.memory.Value;
import legend.core.memory.types.BiFunctionRef;
import legend.core.memory.types.TriConsumerRef;
import legend.game.combat.types.BattleScriptDataBase;
import legend.game.combat.types.BtldScriptData27c;
import legend.game.combat.types.BttlScriptData6c;
import legend.game.combat.types.BttlScriptData6cInner;
import legend.game.combat.types.BttlScriptData6cSub14;
import legend.game.combat.types.BttlScriptData6cSub1c;
import legend.game.combat.types.BttlScriptData6cSub30;
import legend.game.combat.types.BttlScriptData6cSub34;
import legend.game.combat.types.BttlScriptData6cSub44;
import legend.game.combat.types.BttlScriptData6cSub98;
import legend.game.combat.types.BttlScriptData6cSubBase1;
import legend.game.types.DR_MODE;
import legend.game.types.RunningScript;
import legend.game.types.ScriptState;

import javax.annotation.Nullable;

import static legend.core.Hardware.MEMORY;
import static legend.core.MemoryHelper.getMethodAddress;
import static legend.game.Scus94491BpeSegment.FUN_80015d38;
import static legend.game.Scus94491BpeSegment._1f8003e8;
import static legend.game.Scus94491BpeSegment._1f8003ec;
import static legend.game.Scus94491BpeSegment._1f8003f8;
import static legend.game.Scus94491BpeSegment.addToLinkedListHead;
import static legend.game.Scus94491BpeSegment.addToLinkedListTail;
import static legend.game.Scus94491BpeSegment.insertElementIntoLinkedList;
import static legend.game.Scus94491BpeSegment.linkedListAddress_1f8003d8;
import static legend.game.Scus94491BpeSegment.loadScriptFile;
import static legend.game.Scus94491BpeSegment.memcpy;
import static legend.game.Scus94491BpeSegment.rcos;
import static legend.game.Scus94491BpeSegment.removeFromLinkedList;
import static legend.game.Scus94491BpeSegment.rsin;
import static legend.game.Scus94491BpeSegment.tags_1f8003d0;
import static legend.game.Scus94491BpeSegment_8002.strcpy;
import static legend.game.Scus94491BpeSegment_8003.ApplyMatrixLV;
import static legend.game.Scus94491BpeSegment_8003.GetClut;
import static legend.game.Scus94491BpeSegment_8003.GetTPage;
import static legend.game.Scus94491BpeSegment_8003.GsGetLw;
import static legend.game.Scus94491BpeSegment_8003.GsSetLightMatrix;
import static legend.game.Scus94491BpeSegment_8003.RotMatrix_8003faf0;
import static legend.game.Scus94491BpeSegment_8003.SetDrawMode;
import static legend.game.Scus94491BpeSegment_8003.gpuLinkedListSetCommandTransparency;
import static legend.game.Scus94491BpeSegment_8003.setRotTransMatrix;
import static legend.game.Scus94491BpeSegment_8004.FUN_80040ec0;
import static legend.game.Scus94491BpeSegment_8004.RotMatrix_80040010;
import static legend.game.Scus94491BpeSegment_8004.ratan2;
import static legend.game.Scus94491BpeSegment_800b.scriptStatePtrArr_800bc1c0;
import static legend.game.Scus94491BpeSegment_800c.matrix_800c3548;
import static legend.game.combat.Bttl_800c.FUN_800c7488;
import static legend.game.combat.Bttl_800c.FUN_800cfc20;
import static legend.game.combat.Bttl_800c.FUN_800cff54;
import static legend.game.combat.Bttl_800c._800c693c;
import static legend.game.combat.Bttl_800c._800c6948;
import static legend.game.combat.Bttl_800c._800fa754;
import static legend.game.combat.Bttl_800c._800fb954;
import static legend.game.combat.Bttl_800d.FUN_800dc408;
import static legend.game.combat.Bttl_800d.FUN_800de3f4;
import static legend.game.combat.Bttl_800d.FUN_800de544;
import static legend.game.combat.Bttl_800d.ScaleVectorL_SVEC;
import static legend.game.combat.Bttl_800e.FUN_800e3e6c;
import static legend.game.combat.Bttl_800e.FUN_800e60e0;
import static legend.game.combat.Bttl_800e.FUN_800e6170;
import static legend.game.combat.Bttl_800e.FUN_800e61e4;
import static legend.game.combat.Bttl_800e.FUN_800e62a8;
import static legend.game.combat.Bttl_800e.FUN_800e80c4;
import static legend.game.combat.Bttl_800e.FUN_800e8594;
import static legend.game.combat.Bttl_800e.FUN_800e8d04;
import static legend.game.combat.Bttl_800e.FUN_800e8dd4;
import static legend.game.combat.Bttl_800e.FUN_800e9428;
import static legend.game.combat.Bttl_800e.FUN_800e95f0;
import static legend.game.combat.Bttl_800e.FUN_800eac58;

public final class SEffe {
  private SEffe() { }

  private static final Value _800fb794 = MEMORY.ref(2, 0x800fb794L);

  private static final Value _800fb7bc = MEMORY.ref(1, 0x800fb7bcL);

  private static final Value _800fb7c0 = MEMORY.ref(1, 0x800fb7c0L);

  private static final Value _800fb7f0 = MEMORY.ref(1, 0x800fb7f0L);

  private static final SVECTOR _800fb94c = MEMORY.ref(2, 0x800fb94cL, SVECTOR::new);

  private static final Value _80119b7c = MEMORY.ref(4, 0x80119b7cL);

  private static final Value _80119b94 = MEMORY.ref(4, 0x80119b94L);

  private static final Value _80119bac = MEMORY.ref(4, 0x80119bacL);

  private static final Value _80119cb0 = MEMORY.ref(4, 0x80119cb0L);

  private static final Value _80119db4 = MEMORY.ref(4, 0x80119db4L);

  private static final Value _80119f41 = MEMORY.ref(1, 0x80119f41L);

  private static final Value _8011a008 = MEMORY.ref(4, 0x8011a008L);
  private static final Value _8011a00c = MEMORY.ref(4, 0x8011a00cL);
  private static final Value _8011a010 = MEMORY.ref(4, 0x8011a010L);
  private static final Value _8011a014 = MEMORY.ref(1, 0x8011a014L);

  @Method(0x800fb9c0L)
  public static void FUN_800fb9c0(final BttlScriptData6c a0, final BttlScriptData6cSub98 a1, final long a2) {
    // no-op
  }

  @Method(0x800fc8f8L)
  public static void FUN_800fc8f8(@Nullable VECTOR a0, @Nullable final SVECTOR a1) {
    if(a0 == null) {
      a0 = new VECTOR();
    }

    //LAB_800fc920
    final MATRIX s1 = matrix_800c3548;
    final VECTOR sp0x30 = new VECTOR().set(s1.transfer).negate();
    FUN_80040ec0(s1, sp0x30, a0);

    if(a1 != null) {
      sp0x30.set(s1.transfer).negate();
      sp0x30.z.add(0x1000);

      final VECTOR sp0x10 = new VECTOR();
      FUN_80040ec0(s1, sp0x30, sp0x10);
      sp0x10.sub(a0);
      short s0 = (short)ratan2(sp0x10.getX(), sp0x10.getZ());
      a1.setY(s0);

      //LAB_800fca44
      a1.setX((short)ratan2(-sp0x10.getY(), (rcos(-s0) * sp0x10.getZ() - rsin(-s0) * sp0x10.getX()) / 0x1000));
      a1.setZ((short)0);
    }

    //LAB_800fca5c
  }

  @Method(0x800fca78L)
  public static long FUN_800fca78(final BttlScriptData6c s3, final BttlScriptData6cSub98 fp, final long s1, final VECTOR s2, final long a4) {
    long v0;
    long v1;
    long t0;
    long t1;
    long t2;
    long t3;
    long t5;
    long s0;
    long a2;
    long a3;
    long a0;
    long s4;
    long s6;
    long s7;
    long a1;
    long lo;
    long sp50;
    long sp52;
    long sp48;
    long sp1c;
    long sp5a;
    long sp60;
    long sp68;
    long sp40;
    long sp62;
    long sp42;
    long sp18;
    long sp58;
    long sp6a;
    long sp4a;

    final Ref<Long> refX = new Ref<>();
    final Ref<Long> refY = new Ref<>();
    s4 = FUN_800cfc20(MEMORY.ref(4, s1 + 0x68L, SVECTOR::new), MEMORY.ref(4, s1 + 0x2cL, VECTOR::new), s2, refX, refY); //TODO
    if((int)s4 >= 0x28L) {
      a0 = 0x50_0000L / (int)s4;

      v0 = s3._10.svec_16.getX() + MEMORY.ref(2, s1).offset(0x6L).getSigned();
      lo = ((long)(int)a0 * (int)v0) & 0xffff_ffffL;
      a1 = lo;
      s6 = (int)a1 >> 12;

      v0 = s3._10.svec_16.getY() + MEMORY.ref(2, s1).offset(0x8L).getSigned();
      lo = ((long)(int)a0 * (int)v0) & 0xffff_ffffL;
      t0 = lo;
      s7 = (int)t0 >> 12;

      s0 = MEMORY.ref(2, s1).offset(0xeL).getSigned() + s3._10.svec_10.getX() - 0xa00L;

      if((s3._10._24.get() & 0x2L) != 0) {
        final VECTOR sp0x28 = new VECTOR();
        final SVECTOR sp0x38 = new SVECTOR();
        FUN_800fc8f8(sp0x28, sp0x38);
        v0 = -Math.abs(rsin(sp0x38.getY() - s3._10.svec_10.getY()));
        v1 = MEMORY.ref(2, s1).offset(0x4cL).getSigned() - s2.getZ();
        lo = ((long)(int)v1 * (int)v0) & 0xffff_ffffL;
        v0 = lo;

        //LAB_800fcb90
        v0 = (int)v0 / 0x1000;
        sp18 = v0;
        v0 = -Math.abs(rcos(sp0x38.getY() + s3._10.svec_10.getY()));
        v1 = s2.getX() - MEMORY.ref(2, s1).offset(0x48L).getSigned();
        lo = ((long)(int)v1 * (int)v0) & 0xffff_ffffL;
        v0 = lo;

        //LAB_800fcbd4
        v0 = (int)v0 / 0x1000;
        sp18 = sp18 - v0;
        sp1c = s2.getY() - MEMORY.ref(2, s1).offset(0x4aL).getSigned();
        s0 = -ratan2(sp1c, sp18) + 0x400L;
        MEMORY.ref(2, s1).offset(0x48L).setu(s2.getX());
        MEMORY.ref(2, s1).offset(0x4aL).setu(s2.getY());
        MEMORY.ref(2, s1).offset(0x4cL).setu(s2.getZ());
      }

      //LAB_800fcc20
      a1 = fp._5e.get() >>> 1;
      lo = ((long)(int)a1 * (int)s6) & 0xffff_ffffL;
      a1 = lo;
      v1 = fp._5f.get() >>> 1;
      lo = ((long)(int)v1 * (int)s7) & 0xffff_ffffL;
      a0 = s0;
      v0 = -a1;
      v0 = (int)v0 >> 8;
      a1 = (int)a1 >> 8;
      sp40 = v0;
      sp48 = a1;
      v1 = lo;
      v0 = -v1;
      v0 = (int)v0 >> 8;
      v1 = (int)v1 >> 8;
      sp42 = v0;
      sp4a = v1;
      a1 = rcos(s0);
      s0 = rsin(a0);
      t5 = (short)sp40 * (int)s0;
      a0 = (short)sp40 * (int)a1;
      a3 = (short)sp48 * (int)s0;
      t0 = (short)sp48 * (int)a1;
      t1 = (short)sp42 * (int)s0;
      t2 = (short)sp42 * (int)a1;
      t3 = (short)sp4a * (int)s0;
      sp50 = (int)t5 >> 12;
      a0 = (int)a0 >> 12;
      sp60 = a0;
      sp58 = (int)a3 >> 12;
      sp68 = (int)t0 >> 12;
      t5 = (short)sp4a * (int)a1;
      sp62 = (int)t2 >> 12;
      a2 = (int)t1 >> 12;
      sp52 = (int)t1 >> 12;
      sp5a = (int)t3 >> 12;
      sp6a = (int)t5 >> 12;
      final long x = refX.get();
      final long y = refY.get();
      MEMORY.ref(2, a4).offset(0x08L).setu(x + a0 - a2);
      MEMORY.ref(2, a4).offset(0x0aL).setu(y + sp62 + sp50);
      MEMORY.ref(2, a4).offset(0x10L).setu(x + sp68 - sp52);
      MEMORY.ref(2, a4).offset(0x12L).setu(y + sp62 + sp58);
      MEMORY.ref(2, a4).offset(0x18L).setu(x + sp60 - sp5a);
      MEMORY.ref(2, a4).offset(0x1aL).setu(y + sp6a + sp50);
      MEMORY.ref(2, a4).offset(0x20L).setu(x + sp68 - sp5a);
      MEMORY.ref(2, a4).offset(0x22L).setu(y + sp6a + sp58);
    }

    //LAB_800fcde0
    return s4;
  }

  @Method(0x800fd084L)
  public static void FUN_800fd084(final BttlScriptData6c a0, final BttlScriptData6cSub98 a1, final long a2) {
    MEMORY.ref(4, a2).offset(0x2cL).setu(a0._10.vec_04.getX());
    MEMORY.ref(4, a2).offset(0x30L).setu(a0._10.vec_04.getY());
    MEMORY.ref(4, a2).offset(0x34L).setu(a0._10.vec_04.getZ());
    MEMORY.ref(2, a2).offset(0x68L).setu(a0._10.svec_10.getX());
    MEMORY.ref(2, a2).offset(0x6aL).setu(a0._10.svec_10.getY());
    MEMORY.ref(2, a2).offset(0x6cL).setu(a0._10.svec_10.getZ());

    if(MEMORY.ref(2, a2).offset(0x12L).getSigned() == 0) {
      MEMORY.ref(2, a2).offset(0x12L).setu(0x1L);
    }

    //LAB_800fd0dc
    MEMORY.ref(2, a2).offset(0x8aL).setu(MEMORY.ref(2, a2).offset(0x84L).get() / MEMORY.ref(2, a2).offset(0x12L).getSigned());
    MEMORY.ref(2, a2).offset(0x8cL).setu(MEMORY.ref(2, a2).offset(0x86L).get() / MEMORY.ref(2, a2).offset(0x12L).getSigned());
    MEMORY.ref(2, a2).offset(0x8eL).setu(MEMORY.ref(2, a2).offset(0x88L).get() / MEMORY.ref(2, a2).offset(0x12L).getSigned());

    if((a1._24.get() & 0x400_0000L) != 0) {
      MEMORY.ref(2, a2).offset(0x84L).setu(a0._10.svec_1c.getX() << 8);
      MEMORY.ref(2, a2).offset(0x86L).setu(a0._10.svec_1c.getY() << 8);
      MEMORY.ref(2, a2).offset(0x88L).setu(a0._10.svec_1c.getZ() << 8);

      if((a0._10._24.get() & 0x1L) == 0) {
        MEMORY.ref(2, a2).offset(0x8eL).setu(0);
        MEMORY.ref(2, a2).offset(0x8cL).setu(0);
        MEMORY.ref(2, a2).offset(0x8aL).setu(0);
        return;
      }

      //LAB_800fd18c
      MEMORY.ref(2, a2).offset(0x8aL).setu(MEMORY.ref(2, a2).offset(0x84L).get() / MEMORY.ref(2, a2).offset(0x12L).getSigned());
      MEMORY.ref(2, a2).offset(0x8cL).setu(MEMORY.ref(2, a2).offset(0x86L).get() / MEMORY.ref(2, a2).offset(0x12L).getSigned());
      MEMORY.ref(2, a2).offset(0x8eL).setu(MEMORY.ref(2, a2).offset(0x88L).get() / MEMORY.ref(2, a2).offset(0x12L).getSigned());
    }

    //LAB_800fd1d4
  }

  @Method(0x800fd1dcL)
  public static void FUN_800fd1dc(final BttlScriptData6c a0, final BttlScriptData6cSub98 a1, final long a2, final long a3) {
    if((a1._24.get() & 0x800_0000L) == 0 || (a0._10._24.get() & 0x1L) != 0) {
      //LAB_800fd23c
      MEMORY.ref(2, a2).offset(0x84L).subu(MEMORY.ref(2, a2).offset(0x8aL).get());
      MEMORY.ref(2, a2).offset(0x86L).subu(MEMORY.ref(2, a2).offset(0x8cL).get());
      MEMORY.ref(2, a2).offset(0x88L).subu(MEMORY.ref(2, a2).offset(0x8eL).get());
    } else {
      MEMORY.ref(2, a2).offset(0x84L).setu(a0._10.svec_1c.getX() << 8);
      MEMORY.ref(2, a2).offset(0x86L).setu(a0._10.svec_1c.getY() << 8);
      MEMORY.ref(2, a2).offset(0x88L).setu(a0._10.svec_1c.getZ() << 8);
    }

    //LAB_800fd26c
    MEMORY.ref(4, a3).offset(0x00L).setu(MEMORY.ref(2, a2).offset(0x84L).get());
    MEMORY.ref(4, a3).offset(0x04L).setu(MEMORY.ref(2, a2).offset(0x86L).get());
    MEMORY.ref(4, a3).offset(0x08L).setu(MEMORY.ref(2, a2).offset(0x88L).get());
    MEMORY.ref(2, a2).offset(0x50L).addu(MEMORY.ref(2, a2).offset(0x58L).get());
    MEMORY.ref(2, a2).offset(0x52L).addu(MEMORY.ref(2, a2).offset(0x5aL).get());
    MEMORY.ref(2, a2).offset(0x54L).addu(MEMORY.ref(2, a2).offset(0x5cL).get());
    MEMORY.ref(2, a2).offset(0x58L).addu(MEMORY.ref(2, a2).offset(0x60L).get());
    MEMORY.ref(2, a2).offset(0x5aL).addu(MEMORY.ref(2, a2).offset(0x62L).get());
    MEMORY.ref(2, a2).offset(0x5cL).addu(MEMORY.ref(2, a2).offset(0x64L).get());

    if(MEMORY.ref(2, a2).offset(0x52L).getSigned() + MEMORY.ref(4, a2).offset(0x30L).get() >= a0._10.vec_28.getZ()) {
      if((a0._10._24.get() & 0x20L) != 0) {
        MEMORY.ref(2, a2).offset(0x12L).setu(0x1L);
      }

      //LAB_800fd324
      if((a0._10._24.get() & 0x8L) != 0) {
        MEMORY.ref(2, a2).offset(0x52L).setu(a0._10.vec_28.getZ() - MEMORY.ref(2, a2).offset(0x30L).get());
        MEMORY.ref(2, a2).offset(0x5aL).setu(-MEMORY.ref(2, a2).offset(0x5aL).getSigned() / 2);
      }
    }

    //LAB_800fd358
    if((a1._24.get() & 0x200_0000L) == 0) {
      MEMORY.ref(2, a2).offset(0x06L).addu(MEMORY.ref(2, a2).offset(0x0aL).get());
      MEMORY.ref(2, a2).offset(0x08L).addu(MEMORY.ref(2, a2).offset(0x0cL).get());
    }

    //LAB_800fd38c
    if((a1._24.get() & 0x100_0000L) == 0) {
      MEMORY.ref(2, a2).offset(0x0eL).addu(MEMORY.ref(2, a2).offset(0x10L).get());
      MEMORY.ref(2, a2).offset(0x70L).addu(MEMORY.ref(2, a2).offset(0x78L).get());
      MEMORY.ref(2, a2).offset(0x72L).addu(MEMORY.ref(2, a2).offset(0x7aL).get());
      MEMORY.ref(2, a2).offset(0x74L).addu(MEMORY.ref(2, a2).offset(0x7cL).get());
    } else {
      //LAB_800fd3e4
      MEMORY.ref(2, a2).offset(0x0eL).setu(a0._10._24.get() >>> 12 & 0xff0L);
    }

    //LAB_800fd3f8
    MEMORY.ref(2, a2).offset(0x5aL).addu(a0._10.vec_28.getY() >> 8);

    if(a1._6c.get() != 0) {
      MEMORY.ref(2, a2).offset(0x58L).addu(a1.vec_70.getX() >> 8);
      MEMORY.ref(2, a2).offset(0x5aL).addu(a1.vec_70.getY() >> 8);
      MEMORY.ref(2, a2).offset(0x5cL).addu(a1.vec_70.getZ() >> 8);
    }

    //LAB_800fd458
  }

  @Method(0x800fd460L)
  public static long FUN_800fd460(final long a0, final BttlScriptData6c a1, final BttlScriptData6cSub98 a2, final long a3) {
    MEMORY.ref(2, a3).offset(0x4L).subu(0x1L);

    final long s0 = MEMORY.ref(2, a3).offset(0x4L).getSigned();

    //LAB_800fd53c
    if(s0 == -0xfffL) {
      MEMORY.ref(2, a3).offset(0x4L).setu(-0xfffL);
    } else if(s0 == 0) {
      FUN_800fd084(a1, a2, a3);

      if((a1._10._24.get() & 0x10L) != 0) {
        MEMORY.ref(2, a3).offset(0x52L).setu(0);
        long v1 = a2._60.get();

        if(v1 == 0x2L || v1 == 0x5L) {
          //LAB_800fd4f0
          v1 = MEMORY.ref(4, a3).offset(0x44L).get();

          //LAB_800fd504
          for(int i = 0; i < a2._54.get(); i++) {
            MEMORY.ref(2, v1).offset(0x2L).setu(0);
            v1 = v1 + 0x8L;
          }
        }
      }

      //LAB_800fd520
      if((a1._10._24.get() & 0x40L) != 0) {
        MEMORY.ref(2, a3).offset(0x5aL).setu(0);
      }
    }

    //LAB_800fd54c
    a2._88.deref().run(a0, a1, a2, a3);

    if((MEMORY.ref(4, a3).offset(0x90L).get() & 0x1L) == 0) {
      return 0x1L;
    }

    if(MEMORY.ref(2, a3).offset(0x12L).getSigned() > 0) {
      MEMORY.ref(2, a3).offset(0x12L).subu(0x1L);
    }

    //LAB_800fd58c
    if(MEMORY.ref(2, a3).offset(0x12L).getSigned() == 0 && (a1._10._24.get() & 0x80L) == 0) {
      MEMORY.ref(4, a3).offset(0x90L).and(0xffff_fffeL);
      a2._90.deref().run(a0, a1, a2, a3);
      return 0x1L;
    }

    //LAB_800fd5e0
    return 0;
  }

  @Method(0x800fe120L)
  public static void FUN_800fe120(final int index, final ScriptState<BttlScriptData6c> state, final BttlScriptData6c data) {
    long v0;
    long v1;
    long a0;
    long a1;
    long a2;
    long s0;
    long s1;
    long s3;
    long s4;
    long s5;
    long s6;
    long s7;
    long lo;
    long sp38;
    long sp3c;
    long sp40;
    long sp48;
    long sp4a;
    long sp4c;
    final BttlScriptData6cSub98 s2 = data._44.derefAs(BttlScriptData6cSub98.class);
    long sp50 = 0;
    long sp54 = s2._68.get();

    final Memory.TemporaryReservation sp0x28tmp = MEMORY.temp(0x8a);
    final Value sp0x28 = sp0x28tmp.get();

    s2._52.incr();

    if(s2._50.get() != 0) {
      s7 = sp54 + 0x4L;

      //LAB_800fe180
      do {
        if(FUN_800fd460(index, data, s2, sp54) == 0) {
          a0 = MEMORY.ref(4, s7).offset(0x7cL).get();
          v0 = s2._54.get() - 0x1L;
          a2 = a0 + v0 * 0x10L;
          a1 = a2 + 0xcL;

          //LAB_800fe1bc
          for(s4 = 0; s4 < s2._54.get() - 0x1L; s4++) {
            MEMORY.ref(4, a2).offset(0x0L).setu(MEMORY.ref(4, a1).offset(-0x1cL).get());
            MEMORY.ref(4, a1).offset(-0x8L).setu(MEMORY.ref(4, a1).offset(-0x18L).get());
            MEMORY.ref(4, a1).offset(-0x4L).setu(MEMORY.ref(4, a1).offset(-0x14L).get());
            MEMORY.ref(4, a1).offset(0x0L).setu(MEMORY.ref(4, a1).offset(-0x10L).get());
            a2 = a2 - 0x10L;
            a1 = a1 - 0x10L;
          }

          //LAB_800fe1fc
          s2._84.deref().run(data, s2, sp54);

          FUN_800fd1dc(data, s2, sp54, sp0x28.getAddress());

          if((s2._24.get() & 0x1000_0000L) == 0 || (MEMORY.ref(4, s7).offset(0x8cL).get() & 0x8L) == 0) {
            //LAB_800fe280
            sp38 = 0;
            sp3c = 0;
            sp40 = 0;
          } else {
            sp38 = -sp0x28.offset(4, 0x00L).get() / 2;
            sp3c = -sp0x28.offset(4, 0x04L).get() / 2;
            sp40 = -sp0x28.offset(4, 0x08L).get() / 2;
          }

          //LAB_800fe28c
          v0 = MEMORY.ref(4, s7).offset(0x8cL).get();
          v1 = v0 & 0xffff_fff7L;
          v0 = v0 >>> 3;
          v0 = ~v0;
          v0 = v0 & 0x1L;
          v0 = v0 << 3;
          v1 = v1 | v0;
          MEMORY.ref(4, s7).offset(0x8cL).setu(v1);
          if((data._10._00.get() & 0x400_0000L) == 0) {
            assert false : "This seems wrong";
            v0 = FUN_800dc408(0, 0, 0, 0, 0); //TODO last three params were undefined
            s0 = v0 - MEMORY.ref(2, s7).offset(0x4cL).getSigned();
            v0 = FUN_800dc408(0x2L, 0, 0, 0, 0); //TODO last three params were undefined
            MEMORY.ref(2, s7).offset(0x66L).setu(ratan2(s0, v0 - MEMORY.ref(2, s7).offset(0x50L).getSigned()) + 0x400L);
          }

          //LAB_800fe300
          final VECTOR sp0x18 = new VECTOR().set((int)MEMORY.ref(2, s7).offset(0x4cL).getSigned(), (int)MEMORY.ref(2, s7).offset(0x4eL).getSigned(), (int)MEMORY.ref(2, s7).offset(0x50L).getSigned());

          s3 = linkedListAddress_1f8003d8.get();
          linkedListAddress_1f8003d8.addu(0x28L);
          MEMORY.ref(1, s3).offset(0x3L).setu(0x9L);
          MEMORY.ref(4, s3).offset(0x4L).setu(0x2c80_8080L);
          v0 = data._10._00.get();
          v1 = MEMORY.ref(1, s3).offset(0x7L).get();
          v0 = v0 >>> 29;
          v0 = v0 & 0x2L;
          v1 = v1 | v0;
          MEMORY.ref(1, s3).offset(0x7L).setu(v1);
          v1 = s2._5a.get();
          v0 = s2._58.get();
          v1 = v1 & 0x100L;
          v1 = v1 >>> 4;
          v0 = v0 & 0x3ffL;
          v0 = v0 >>> 6;
          v1 = v1 | v0;
          MEMORY.ref(2, s3).offset(0x16L).setu(v1);
          v0 = data._10._00.get();
          v0 = v0 >>> 23;
          v0 = v0 & 0x60L;
          v1 = v1 | v0;
          MEMORY.ref(2, s3).offset(0x16L).setu(v1);
          v0 = s2._58.get();
          v0 = v0 & 0x3fL;
          v0 = v0 << 2;
          MEMORY.ref(1, s3).offset(0xcL).setu(v0);
          v0 = s2._5a.get();
          MEMORY.ref(1, s3).offset(0xdL).setu(v0);
          v0 = s2._58.get();
          v1 = s2._5e.get();
          v0 = v0 & 0x3fL;
          v0 = v0 << 2;
          v0 = v0 + 0xffL;
          v1 = v1 + v0;
          MEMORY.ref(1, s3).offset(0x14L).setu(v1);
          v0 = s2._5a.get();
          MEMORY.ref(1, s3).offset(0x15L).setu(v0);
          v0 = s2._58.get();
          v0 = v0 & 0x3fL;
          v0 = v0 << 2;
          MEMORY.ref(1, s3).offset(0x1cL).setu(v0);
          v0 = s2._5a.get();
          v1 = s2._5f.get();
          v0 = v0 + 0xffL;
          v1 = v1 + v0;
          MEMORY.ref(1, s3).offset(0x1dL).setu(v1);
          v0 = s2._58.get();
          v1 = s2._5e.get();
          v0 = v0 & 0x3fL;
          v0 = v0 << 2;
          v0 = v0 + 0xffL;
          v1 = v1 + v0;
          MEMORY.ref(1, s3).offset(0x24L).setu(v1);
          v0 = s2._5a.get();
          v1 = s2._5f.get();
          v0 = v0 + 0xffL;
          v1 = v1 + v0;
          MEMORY.ref(1, s3).offset(0x25L).setu(v1);
          v0 = s2._5c.get() & 0x7fffL;
          MEMORY.ref(2, s3).offset(0xeL).setu(v0);

          v1 = sp0x28.offset(4, 0x00L).get() + sp38;
          if((int)v1 >= 0) {
            a0 = 0x8000L;
            if((int)a0 >= (int)v1) {
              a0 = v1;
            }
          } else {
            //LAB_800fe46c
            a0 = 0;
          }

          //LAB_800fe470
          v1 = sp0x28.offset(4, 0x04L).get() + sp3c;
          sp0x28.offset(4, 0x00L).setu(a0);
          if((int)v1 >= 0) {
            a0 = 0x8000L;
            if((int)a0 >= (int)v1) {
              a0 = v1;
            }
          } else {
            //LAB_800fe4a4
            a0 = 0;
          }

          //LAB_800fe4a8
          v1 = sp0x28.offset(4, 0x08L).get() + sp40;
          sp0x28.offset(4, 0x04L).setu(a0);
          if((int)v1 >= 0) {
            a2 = 0x8000L;
            if((int)a2 >= (int)v1) {
              a2 = v1;
            }
          } else {
            //LAB_800fe4dc
            a2 = 0;
          }

          //LAB_800fe4e4
          sp0x28.offset(4, 0x08L).setu(a2);
          MEMORY.ref(1, s3).offset(0x4L).setu((int)sp0x28.offset(4, 0x00L).get() >> 8);
          MEMORY.ref(1, s3).offset(0x5L).setu((int)sp0x28.offset(4, 0x04L).get() >> 8);
          MEMORY.ref(1, s3).offset(0x6L).setu((int)sp0x28.offset(4, 0x08L).get() >> 8);

          v0 = FUN_800fca78(data, s2, sp54, sp0x18, s3);
          a0 = data._10._22.get();
          s5 = (int)v0 >> 2;
          v1 = s5 + a0;
          if((int)v1 >= 0xa0L) {
            if((int)v1 >= 0xffeL) {
              a0 = 0xffeL - s5;
            }

            //LAB_800fe548
            a0 = s5 + a0;
            a0 = (int)a0 >> 2;
            a0 = a0 << 2;
            a0 = tags_1f8003d0.getPointer() + a0;
            insertElementIntoLinkedList(a0, s3);
          }

          //LAB_800fe564
          if((s2._24.get() & 0x6000_0000L) != 0) {
            s1 = MEMORY.ref(4, s7).offset(0x7cL).get();
            v0 = MEMORY.ref(4, s3).offset(0x8L).get();
            MEMORY.ref(4, s1).offset(0x0L).setu(v0);
            v0 = MEMORY.ref(4, s3).offset(0x10L).get();
            s1 = s1 + 0x4L;
            MEMORY.ref(4, s1).offset(0x0L).setu(v0);
            v0 = MEMORY.ref(4, s3).offset(0x18L).get();
            s1 = s1 + 0x4L;
            MEMORY.ref(4, s1).offset(0x0L).setu(v0);
            v0 = MEMORY.ref(4, s3).offset(0x20L).get();
            MEMORY.ref(4, s1).offset(0x4L).setu(v0);
            lo = (int)sp0x28.offset(4, 0x00L).get() / s2._54.get();
            v0 = lo;
            s1 = MEMORY.ref(4, s7).offset(0x7cL).get();
            sp48 = v0;
            lo = (int)sp0x28.offset(4, 0x04L).get() / s2._54.get();
            v0 = lo;
            sp4a = v0;
            lo = (int)sp0x28.offset(4, 0x08L).get() / s2._54.get();
            v0 = lo;
            sp4c = v0;
            v1 = s2._54.get();
            s6 = -MEMORY.ref(2, s7).offset(0x0L).getSigned();
            if((int)v1 < (int)s6) {
              s6 = v1;
            }

            //LAB_800fe61c
            if((int)s6 > 0) {
              s4 = 0;
              a2 = s3;

              //LAB_800fe628
              do {
                a1 = 0x9L;
                s0 = linkedListAddress_1f8003d8.get();
                a0 = s0;
                linkedListAddress_1f8003d8.addu(0x28L);

                //LAB_800fe644
                do {
                  MEMORY.ref(4, a0).offset(0x0L).setu(MEMORY.ref(4, a2).offset(0x0L).get());
                  a2 = a2 + 0x4L;
                  a0 = a0 + 0x4L;
                  a1 = a1 - 0x1L;
                } while((int)a1 >= 0);

                MEMORY.ref(1, s0).offset(0x3L).setu(0x9L);
                MEMORY.ref(4, s0).offset(0x4L).setu(0x2c80_8080L);
                v0 = data._10._00.get() >>> 29;
                v0 = v0 & 0x2L;
                MEMORY.ref(1, s0).offset(0x7L).oru(v0);
                a1 = data._10._00.get() >>> 30;
                a1 = a1 & 0x1L;
                gpuLinkedListSetCommandTransparency(s3, a1 != 0);
                MEMORY.ref(1, s0).offset(0x4L).setu((int)sp0x28.offset(4, 0x00L).get() >> 8);
                MEMORY.ref(1, s0).offset(0x5L).setu((int)sp0x28.offset(4, 0x04L).get() >> 8);
                MEMORY.ref(1, s0).offset(0x6L).setu((int)sp0x28.offset(4, 0x08L).get() >> 8);
                sp0x28.offset(4, 0x00L).subu(sp48);
                sp0x28.offset(4, 0x04L).subu(sp4a);
                sp0x28.offset(4, 0x08L).subu(sp4c);
                v0 = MEMORY.ref(2, s1).offset(0x0L).get();

                MEMORY.ref(2, s0).offset(0x8L).setu(v0);
                v0 = MEMORY.ref(2, s1).offset(0x2L).get();
                s1 = s1 + 0x4L;
                MEMORY.ref(2, s0).offset(0xaL).setu(v0);
                v0 = MEMORY.ref(2, s1).offset(0x0L).get();

                MEMORY.ref(2, s0).offset(0x10L).setu(v0);
                v0 = MEMORY.ref(2, s1).offset(0x2L).get();
                s1 = s1 + 0x4L;
                MEMORY.ref(2, s0).offset(0x12L).setu(v0);
                v0 = MEMORY.ref(2, s1).offset(0x0L).get();

                MEMORY.ref(2, s0).offset(0x18L).setu(v0);
                v0 = MEMORY.ref(2, s1).offset(0x2L).get();
                s1 = s1 + 0x4L;
                MEMORY.ref(2, s0).offset(0x1aL).setu(v0);
                v0 = MEMORY.ref(2, s1).offset(0x0L).get();

                MEMORY.ref(2, s0).offset(0x20L).setu(v0);
                v0 = MEMORY.ref(2, s1).offset(0x2L).get();

                MEMORY.ref(2, s0).offset(0x22L).setu(v0);
                a0 = data._10._22.get();

                v1 = s5 + a0;
                if((int)v1 >= 0xa0L) {
                  if((int)v1 >= 0xffeL) {
                    a0 = 0xffeL - s5;
                  }

                  //LAB_800fe78c
                  a0 = tags_1f8003d0.getPointer() + (s5 + a0) / 0x4L * 0x4L;
                  insertElementIntoLinkedList(a0, s0);
                }

                //LAB_800fe7a8
                s1 = s1 + 0x4L;
                s4 = s4 + 0x1L;
                a2 = s3;
              } while((int)s4 < (int)s6);
            }
          }
        }

        //LAB_800fe7b8
        sp50 = sp50 + 0x1L;
        sp54 = sp54 + 0x94L;
        s7 = s7 + 0x94L;
      } while(sp50 < s2._50.get());
    }

    sp0x28tmp.release();

    //LAB_800fe7ec
    if(s2._6c.get() != 0) {
      s2.vec_70.setX(s2.vec_70.getX() * s2._80.get() >> 8);
      s2.vec_70.setY(s2.vec_70.getY() * s2._80.get() >> 8);
      s2.vec_70.setZ(s2.vec_70.getZ() * s2._80.get() >> 8);
    }

    //LAB_800fe848
  }

  @Method(0x800fe8b8L)
  public static void FUN_800fe8b8(final int index, final ScriptState<BttlScriptData6c> state, final BttlScriptData6c data) {
    assert false;
  }

  @Method(0x800fea70L)
  public static long FUN_800fea70(long a0, long a1, final long a2, final long a3) {
    long v0;
    long v1;
    long s0;
    long s2;
    long hi;
    v1 = 0xff_0000L;
    s2 = 0x8010_0000L;
    v0 = MEMORY.ref(4, s2).offset(-0x58acL).get();
    v1 = v1 | 0xf001L;
    v0 = v0 + 0x1L;
    s0 = v0 << 5;
    s0 = s0 + v0;
    s0 = s0 << 2;
    s0 = s0 - v0;
    s0 = s0 << 2;
    s0 = s0 - v0;
    s0 = s0 << 2;
    s0 = s0 + v0;
    v0 = s0 << 5;
    s0 = s0 + v0;
    hi = (s0 & 0xffff_ffffL) * (v1 & 0xffff_ffffL) >>> 32;
    MEMORY.ref(4, s2).offset(-0x58acL).setu(s0);
    v1 = hi;
    v1 = v1 >>> 4;
    v0 = v1 << 12;
    v0 = v0 + v1;
    s0 = s0 - v0;
    s0 = s0 << 16;
    s0 = (int)s0 >> 16;
    a0 = s0;
    v0 = rcos(a0);
    a1 = 0x6816_0000L;
    a0 = MEMORY.ref(4, s2).offset(-0x58acL).get();
    a1 = a1 | 0x8169L;
    a0 = a0 + 0x1L;
    v1 = a0 << 5;
    v1 = v1 + a0;
    v1 = v1 << 2;
    v1 = v1 - a0;
    v1 = v1 << 2;
    v1 = v1 - a0;
    v1 = v1 << 2;
    v1 = v1 + a0;
    a0 = v1 << 5;
    v1 = v1 + a0;
    hi = (v1 & 0xffff_ffffL) * (a1 & 0xffff_ffffL) >>> 32;
    v0 = (int)v0 >> 8;
    MEMORY.ref(2, a2).offset(0x58L).setu(v0);
    a0 = s0;
    MEMORY.ref(4, s2).offset(-0x58acL).setu(v1);
    a1 = hi;
    v0 = v1 - a1;
    v0 = v0 >>> 1;
    a1 = a1 + v0;
    a1 = a1 >>> 6;
    v0 = a1 << 1;
    v0 = v0 + a1;
    v0 = v0 << 3;
    v0 = v0 - a1;
    v0 = v0 << 2;
    v0 = v0 - a1;
    v1 = v1 - v0;
    v1 = v1 + 0xaL;
    v1 = -v1;
    MEMORY.ref(2, a2).offset(0x5aL).setu(v1);
    v0 = rsin(a0);
    a1 = 0x446f_0000L;
    v1 = MEMORY.ref(4, s2).offset(-0x58acL).get();
    a1 = a1 | 0x8657L;
    v1 = v1 + 0x1L;
    a0 = v1 << 5;
    a0 = a0 + v1;
    a0 = a0 << 2;
    a0 = a0 - v1;
    a0 = a0 << 2;
    a0 = a0 - v1;
    a0 = a0 << 2;
    a0 = a0 + v1;
    v1 = a0 << 5;
    a0 = a0 + v1;
    hi = (a0 & 0xffff_ffffL) * (a1 & 0xffff_ffffL) >>> 32;
    v1 = (int)v0 >> 8;
    v0 = s0;
    MEMORY.ref(2, a2).offset(0x5cL).setu(v1);
    MEMORY.ref(4, s2).offset(-0x58acL).setu(a0);
    a1 = hi;
    v1 = a0 - a1;
    v1 = v1 >>> 1;
    a1 = a1 + v1;
    a1 = a1 >>> 6;
    v1 = a1 << 1;
    v1 = v1 + a1;
    v1 = v1 << 3;
    v1 = v1 + a1;
    v1 = v1 << 2;
    v1 = v1 + a1;
    a0 = a0 - v1;
    a0 = a0 - 0x32L;
    a0 = a0 << 8;
    v1 = MEMORY.ref(2, a2).offset(0x84L).get();
    a1 = MEMORY.ref(2, a2).offset(0x88L).get();
    v1 = v1 + a0;
    MEMORY.ref(2, a2).offset(0x84L).setu(v1);
    v1 = MEMORY.ref(2, a2).offset(0x86L).get();
    a1 = a1 + a0;
    MEMORY.ref(2, a2).offset(0x88L).setu(a1);
    v1 = v1 + a0;
    MEMORY.ref(2, a2).offset(0x86L).setu(v1);
    return v0;
  }

  @Method(0x80100d58L)
  public static void FUN_80100d58(final long a0, final BttlScriptData6c a1, final BttlScriptData6cSub98 a2, final long a3) {
    // no-op
  }

  @Method(0x801012a0L)
  public static void FUN_801012a0(long a0, long a1) {
    assert false;
  }

  @Method(0x801012d4L)
  public static void FUN_801012d4(long a0, long a1) {
    assert false;
  }

  @Method(0x80101e84L)
  public static void FUN_80101e84(long a0, long a1, long a2, long a3) {
    MEMORY.ref(1, a0).offset(0x60L).setu(0);
    MEMORY.ref(2, a0).offset(0x54L).setu(0);

    if((MEMORY.ref(4, a0).offset(0x24L).get() & 0x6000_0000L) != 0) {
      long s2 = MEMORY.ref(4, a0).offset(0x68L).get();
      long v0 = (MEMORY.ref(4, a0).offset(0x24L).get() & 0x6000_0000L) >>> 27;
      MEMORY.ref(2, a0).offset(0x54L).setu(_800fb794.offset(2, v0).get());

      //LAB_80101f2c
      for(int i = 0; i < MEMORY.ref(2, a0).offset(0x50L).get(); i++) {
        long v1 = linkedListAddress_1f8003d8.get();
        linkedListAddress_1f8003d8.addu(0x28L);
        MEMORY.ref(1, v1).offset(0x3L).setu(0x9L);
        MEMORY.ref(4, v1).offset(0x4L).setu(0x2c80_8080L);
        MEMORY.ref(4, s2).offset(0x80L).setu(addToLinkedListHead(MEMORY.ref(2, a0).offset(0x54L).get() * 0x10L));
        s2 = s2 + 0x94L;
      }
    }

    //LAB_80101f70
    if((a3 & 0xf_ff00L) == 0xf_ff00L) {
      long a0_0 = (a3 & 0xffL) * 0x8L;
      long v0 = _800c6948.get() + a0_0;
      MEMORY.ref(2, a0).offset(0x58L).setu(MEMORY.ref(2, v0).offset(0x0L).get());
      MEMORY.ref(2, a0).offset(0x5aL).setu(MEMORY.ref(2, v0).offset(0x2L).get());
      MEMORY.ref(1, a0).offset(0x5eL).setu(MEMORY.ref(1, v0).offset(0x4L).get());
      MEMORY.ref(1, a0).offset(0x5fL).setu(MEMORY.ref(1, v0).offset(0x5L).get());
      MEMORY.ref(2, a0).offset(0x5cL).setu(MEMORY.ref(2, v0).offset(0x6L).get());
    } else {
      //LAB_80101fec
      long v0 = FUN_800eac58(a3 | 0x400_0000L);
      v0 = v0 + MEMORY.ref(4, v0).offset(0x8L).get();
      MEMORY.ref(2, a0).offset(0x58L).setu(MEMORY.ref(2, v0).offset(0x0L).get());
      MEMORY.ref(2, a0).offset(0x5aL).setu(MEMORY.ref(2, v0).offset(0x2L).get());
      MEMORY.ref(1, a0).offset(0x5eL).setu(MEMORY.ref(1, v0).offset(0x4L).get() * 0x4L);
      MEMORY.ref(1, a0).offset(0x5fL).setu(MEMORY.ref(1, v0).offset(0x6L).get());
      MEMORY.ref(2, a0).offset(0x5cL).setu(GetClut(MEMORY.ref(2, v0).offset(0x8L).getSigned(), MEMORY.ref(2, v0).offset(0xaL).getSigned()));
    }

    //LAB_80102048
    MEMORY.ref(2, a0).offset(0x34L).setu(MEMORY.ref(1, a0).offset(0x5eL).get() >>> 1);
    MEMORY.ref(2, a0).offset(0x36L).setu(MEMORY.ref(1, a0).offset(0x5fL).get() >>> 1);
  }

  @Method(0x80102088L)
  public static long FUN_80102088(final RunningScript s2) {
    long v0 = (int)s2.params_20.get(2).deref().get() / 0x100000;
    long s6 = FUN_800e80c4(s2.scriptStateIndex_00.get(), 0x98L, null, _80119b7c.offset(v0 * 0x4L).deref(4).cast(TriConsumerRef::new), MEMORY.ref(4, getMethodAddress(SEffe.class, "FUN_800fe8b8", int.class, ScriptState.classFor(BttlScriptData6c.class), BttlScriptData6c.class), TriConsumerRef::new), BttlScriptData6cSub98::new);
    long v1 = s2.params_20.get(3).deref().get() & 0xffffL;
    long s0 = v1 * 0x94L;
    long s3 = scriptStatePtrArr_800bc1c0.get((int)s6).deref().innerStruct_00.getPointer(); //TODO
    long s1 = MEMORY.ref(4, s3).offset(0x44L).get();
    MEMORY.ref(2, s1).offset(0x50L).setu(s2.params_20.get(3).deref().get());
    MEMORY.ref(4, s1).offset(0x68L).setu(addToLinkedListHead(s0));

    if(_8011a00c.get() == 0) {
      _8011a00c.setu(s1);
    }

    //LAB_801021a8
    v0 = _8011a010.get();

    if(v0 != 0) {
      MEMORY.ref(4, v0).offset(0x94L).setu(s1);
    }

    //LAB_801021c0
    MEMORY.ref(4, s1).offset(0x64L).setu(s0);
    MEMORY.ref(4, s1).offset(0x4L).setu(s2.params_20.get(1).deref().get());
    MEMORY.ref(4, s1).offset(0x0L).setu(s6);
    MEMORY.ref(4, s1).offset(0x84L).setu(_80119bac.offset(s2.params_20.get(4).deref().get() * 0x4L).get());
    MEMORY.ref(4, s1).offset(0x88L).setu(_80119cb0.offset(s2.params_20.get(4).deref().get() * 0x4L).get());
    _8011a010.setu(s1);
    MEMORY.ref(2, s1).offset(0x52L).setu(0);
    MEMORY.ref(2, s1).offset(0x34L).setu(0);
    MEMORY.ref(2, s1).offset(0x36L).setu(0);
    MEMORY.ref(1, s1).offset(0x6cL).setu(0);
    MEMORY.ref(4, s1).offset(0x94L).setu(0);
    MEMORY.ref(4, s1).offset(0x8cL).setu(_80119db4.offset(s2.params_20.get(4).deref().get() * 0x4L).get());
    s2.params_20.get(0).deref().set(s6);

    //LAB_8010223c
    for(int i = 0; i < 9; i++) {
      MEMORY.ref(4, s1).offset(0x8L).offset(i * 0x4L).setu(s2.params_20.get(i).deref().get());
    }

    v0 = s2.params_20.get(3).deref().get() & 0xffffL;
    long s5 = s1 + 0x8L;

    //LAB_80102278
    long s2_0 = MEMORY.ref(4, s1).offset(0x68L).get();
    for(int i = 0; i < v0; i++) {
      _8011a008.setu(i);
      FUN_80101308(s6, s3, s1, s2_0, s5);
      memcpy(s2_0 + 0x3cL, s2_0 + 0x50L, 8);
      s2_0 = s2_0 + 0x94L;
    }

    //LAB_801022b4
    if(MEMORY.ref(1, s1).offset(0x61L).getSigned() != 0) {
      v0 = getMethodAddress(SEffe.class, "FUN_801012d4", long.class, long.class);
    } else {
      //LAB_801022cc
      v0 = getMethodAddress(SEffe.class, "FUN_801012a0", long.class, long.class);
    }

    //LAB_801022d4
    MEMORY.ref(4, s1).offset(0x90L).setu(v0);
    v0 = (int)s2.params_20.get(2).deref().get() / 0x100000;
    MEMORY.ref(2, s1).offset(0x54L).setu(0);
    _80119b94.offset(v0 * 4).deref(4).call(s1, s2_0, s1 + 0x8L, s2.params_20.get(2).deref().get());
    MEMORY.ref(4, s3).offset(0x10L).oru(0x5000_0000L);
    MEMORY.ref(4, s3).offset(0x4L).oru(0x4_0000L);
    FUN_80102534();
    return 0;
  }

  @Method(0x80101308L)
  public static void FUN_80101308(long a0, long a1, long a2, long a3, long a4) {
    long v0;
    long v1;
    long t0;
    long t1;
    long t2;
    long t3;
    long t4;
    long t5;
    long t6;
    long t7;
    long s0;
    long s1;
    long s2;
    long s3;
    long s4;
    long s5;
    long s6;
    long s7;
    long fp;
    long hi;
    long lo;
    long sp3c;
    s6 = a4;
    fp = a2;
    sp3c = a1;
    a1 = MEMORY.ref(4, s6).offset(0x1cL).get();
    a2 = MEMORY.ref(2, s6).offset(0x14L).get();
    s0 = MEMORY.ref(2, s6).offset(0x20L).get();
    v0 = a1 & 0xffL;
    if(v0 != 0) {
      s3 = a3;
    } else {
      s3 = a3;
      a0 = -0x100L;
      v1 = 0x8012_0000L;
      v1 = v1 - 0x6814L;
      v0 = s0 << 2;
      v0 = v0 + v1;
      v0 = MEMORY.ref(1, v0).offset(0x2L).get();
      a0 = a1 & a0;
      a0 = a0 | v0;
      MEMORY.ref(4, s6).offset(0x1cL).setu(a0);
    }

    //LAB_8010137c
    v0 = MEMORY.ref(1, s6).offset(0x1dL).get();
    a1 = MEMORY.ref(4, s6).offset(0x1cL).get();
    if(v0 != 0) {
      s1 = 0xff_0000L;
    } else {
      s1 = 0xff_0000L;
      a0 = 0xffff_0000L;
      a0 = a0 | 0xffL;
      v1 = 0x8012_0000L;
      v1 = v1 - 0x6814L;
      v0 = s0 & 0xffffL;
      v0 = v0 << 2;
      v0 = v0 + v1;
      v0 = MEMORY.ref(1, v0).offset(0x1L).get();
      a0 = a1 & a0;
      v0 = v0 << 8;
      a0 = a0 | v0;
      MEMORY.ref(4, s6).offset(0x1cL).setu(a0);
      a1 = MEMORY.ref(4, s6).offset(0x1cL).get();
    }

    //LAB_801013c0
    v0 = a1 & s1;
    if(v0 != 0) {
      t7 = 0xff_0000L;
    } else {
      t7 = 0xff_0000L;
      a0 = 0xff00_0000L;
      a0 = a0 | 0xffffL;
      v1 = 0x8012_0000L;
      v1 = v1 - 0x6814L;
      v0 = s0 & 0xffffL;
      v0 = v0 << 2;
      v0 = v0 + v1;
      v0 = MEMORY.ref(1, v0).offset(0x0L).get();
      a0 = a1 & a0;
      v0 = v0 << 16;
      a0 = a0 | v0;
      MEMORY.ref(4, s6).offset(0x1cL).setu(a0);
    }

    //LAB_80101400
    t7 = t7 | 0xf001L;
    t3 = 0xfe0_0000L;
    v0 = 0x8012_0000L;
    v0 = v0 - 0x6814L;
    t4 = s0 & 0xffffL;
    t2 = t4 << 2;
    v0 = t2 + v0;
    t3 = t3 | 0x3f81L;
    t6 = 0x8010_0000L;
    a3 = 0x446f_0000L;
    a3 = a3 | 0x8657L;
    v0 = MEMORY.ref(1, v0).offset(0x3L).get();
    t2 = t2 + t4;
    MEMORY.ref(1, fp).offset(0x61L).setu(v0);
    v1 = MEMORY.ref(4, t6).offset(-0x58acL).get();
    a0 = MEMORY.ref(1, s6).offset(0x1dL).get();
    t1 = MEMORY.ref(4, s6).offset(0x1cL).get();
    v1 = v1 + 0x1L;
    v0 = v1 << 5;
    v0 = v0 + v1;
    v0 = v0 << 2;
    v0 = v0 - v1;
    v0 = v0 << 2;
    v0 = v0 - v1;
    v0 = v0 << 2;
    v0 = v0 + v1;
    v1 = v0 << 5;
    v0 = v0 + v1;
    v1 = a2 & 0xffffL;
    v1 = v1 + 0x1L;
    MEMORY.ref(4, t6).offset(-0x58acL).setu(v0);
    hi = (v0 & 0xffff_ffffL) % (v1 & 0xffff_ffffL);
    v1 = hi;
    v0 = 0x73L;
    MEMORY.ref(1, s3).offset(0x0L).setu(v0);
    v0 = 0x6dL;
    MEMORY.ref(1, s3).offset(0x1L).setu(v0);
    v0 = 0x6bL;
    MEMORY.ref(1, s3).offset(0x2L).setu(v0);
    v0 = MEMORY.ref(4, t6).offset(-0x58acL).get();
    t2 = t2 << 1;
    MEMORY.ref(2, s3).offset(0x54L).setu(0);
    MEMORY.ref(2, s3).offset(0x52L).setu(0);
    MEMORY.ref(2, s3).offset(0x50L).setu(0);
    MEMORY.ref(2, s3).offset(0x5cL).setu(0);
    MEMORY.ref(2, s3).offset(0x5aL).setu(0);
    MEMORY.ref(2, s3).offset(0x58L).setu(0);
    MEMORY.ref(2, s3).offset(0x8L).setu(0);
    MEMORY.ref(2, s3).offset(0x6L).setu(0);
    MEMORY.ref(2, s3).offset(0xcL).setu(0);
    MEMORY.ref(2, s3).offset(0xaL).setu(0);
    MEMORY.ref(2, s3).offset(0x64L).setu(0);
    MEMORY.ref(2, s3).offset(0x62L).setu(0);
    MEMORY.ref(2, s3).offset(0x60L).setu(0);
    MEMORY.ref(2, s3).offset(0x8eL).setu(0);
    MEMORY.ref(2, s3).offset(0x8cL).setu(0);
    v0 = v0 + 0x1L;
    a1 = v0 << 5;
    a1 = a1 + v0;
    a1 = a1 << 2;
    a1 = a1 - v0;
    a1 = a1 << 2;
    a1 = a1 - v0;
    a1 = a1 << 2;
    a1 = a1 + v0;
    v0 = a1 << 5;
    a1 = a1 + v0;
    hi = (a1 & 0xffff_ffffL) * (t7 & 0xffff_ffffL) >>> 32;
    MEMORY.ref(2, s3).offset(0x8aL).setu(0);
    t1 = t1 & s1;
    v0 = MEMORY.ref(4, s3).offset(0x90L).get();
    t1 = (int)t1 >> 16;
    MEMORY.ref(2, s3).offset(0x88L).setu(a0);
    MEMORY.ref(2, s3).offset(0x86L).setu(a0);
    MEMORY.ref(2, s3).offset(0x84L).setu(a0);
    MEMORY.ref(4, t6).offset(-0x58acL).setu(a1);
    v0 = v0 | 0x1L;
    MEMORY.ref(4, s3).offset(0x90L).setu(v0);
    v0 = a1 + 0x1L;
    t0 = hi;
    t0 = t0 >>> 4;
    a2 = t0 << 12;
    a2 = a2 + t0;
    a1 = a1 - a2;
    v1 = v1 + 0x1L;
    MEMORY.ref(2, s3).offset(0x4L).setu(v1);
    v1 = v0 << 5;
    v1 = v1 + v0;
    v1 = v1 << 2;
    v1 = v1 - v0;
    v1 = v1 << 2;
    v1 = v1 - v0;
    v1 = v1 << 2;
    v1 = v1 + v0;
    v0 = v1 << 5;
    v1 = v1 + v0;
    v0 = 0xff80_0000L;
    v0 = v0 | 0x3fe1L;
    hi = (v1 & 0xffff_ffffL) * (v0 & 0xffff_ffffL) >>> 32;
    v0 = v1 + 0x1L;
    a0 = v0 << 5;
    a0 = a0 + v0;
    a0 = a0 << 2;
    a0 = a0 - v0;
    a0 = a0 << 2;
    a0 = a0 - v0;
    a0 = a0 << 2;
    a0 = a0 + v0;
    v0 = a0 << 5;
    a0 = a0 + v0;
    MEMORY.ref(2, s3).offset(0xeL).setu(a1);
    MEMORY.ref(4, t6).offset(-0x58acL).setu(v1);
    MEMORY.ref(4, t6).offset(-0x58acL).setu(a0);
    t5 = hi;
    a1 = t5 >>> 9;
    v0 = a1 << 9;
    v0 = v0 + a1;
    v1 = v1 - v0;
    v1 = v1 - 0x100L;
    v0 = a0 + 0x1L;
    MEMORY.ref(2, s3).offset(0x10L).setu(v1);
    v1 = v0 << 5;
    v1 = v1 + v0;
    v1 = v1 << 2;
    v1 = v1 - v0;
    hi = (a0 & 0xffff_ffffL) * (t7 & 0xffff_ffffL) >>> 32;
    v1 = v1 << 2;
    v1 = v1 - v0;
    v1 = v1 << 2;
    v1 = v1 + v0;
    v0 = v1 << 5;
    v1 = v1 + v0;
    v0 = v1 + 0x1L;
    a1 = v0 << 5;
    a1 = a1 + v0;
    a1 = a1 << 2;
    a1 = a1 - v0;
    s2 = hi;
    a1 = a1 << 2;
    a1 = a1 - v0;
    hi = (v1 & 0xffff_ffffL) * (t7 & 0xffff_ffffL) >>> 32;
    a1 = a1 << 2;
    a1 = a1 + v0;
    v0 = a1 << 5;
    a1 = a1 + v0;
    MEMORY.ref(4, t6).offset(-0x58acL).setu(v1);
    MEMORY.ref(4, t6).offset(-0x58acL).setu(a1);
    a2 = s2 >>> 4;
    v0 = a2 << 12;
    v0 = v0 + a2;
    a0 = a0 - v0;
    MEMORY.ref(2, s3).offset(0x70L).setu(a0);
    t0 = hi;
    a0 = t0 >>> 4;
    v0 = a0 << 12;
    v0 = v0 + a0;
    hi = (a1 & 0xffff_ffffL) * (t7 & 0xffff_ffffL) >>> 32;
    v1 = v1 - v0;
    v0 = a1 + 0x1L;
    MEMORY.ref(2, s3).offset(0x72L).setu(v1);
    v1 = v0 << 5;
    v1 = v1 + v0;
    v1 = v1 << 2;
    v1 = v1 - v0;
    v1 = v1 << 2;
    v1 = v1 - v0;
    v1 = v1 << 2;
    v1 = v1 + v0;
    t5 = hi;
    v0 = v1 << 5;
    v1 = v1 + v0;
    hi = (v1 & 0xffff_ffffL) * (t3 & 0xffff_ffffL) >>> 32;
    v0 = v1 + 0x1L;
    a0 = v0 << 5;
    a0 = a0 + v0;
    a0 = a0 << 2;
    a0 = a0 - v0;
    a0 = a0 << 2;
    a0 = a0 - v0;
    a0 = a0 << 2;
    a0 = a0 + v0;
    v0 = a0 << 5;
    t0 = t5 >>> 4;
    t5 = hi;
    a0 = a0 + v0;
    MEMORY.ref(4, t6).offset(-0x58acL).setu(v1);
    hi = (a0 & 0xffff_ffffL) * (t3 & 0xffff_ffffL) >>> 32;
    a2 = t0 << 12;
    a2 = a2 + t0;
    a1 = a1 - a2;
    MEMORY.ref(2, s3).offset(0x74L).setu(a1);
    a1 = t5 >>> 3;
    v0 = a1 << 7;
    v0 = v0 + a1;
    v1 = v1 - v0;
    v1 = v1 - 0x40L;
    MEMORY.ref(2, s3).offset(0x78L).setu(v1);
    v1 = a0 + 0x1L;
    t3 = hi;
    v0 = t3 >>> 3;
    a1 = v0 << 7;
    a1 = a1 + v0;
    v0 = v1 << 5;
    v0 = v0 + v1;
    v0 = v0 << 2;
    v0 = v0 - v1;
    v0 = v0 << 2;
    v0 = v0 - v1;
    v0 = v0 << 2;
    v0 = v0 + v1;
    v1 = v0 << 5;
    a2 = v0 + v1;
    hi = (a2 & 0xffff_ffffL) * (a3 & 0xffff_ffffL) >>> 32;
    MEMORY.ref(2, s3).offset(0x7cL).setu(0);
    MEMORY.ref(2, s3).offset(0x12L).setu(t1);
    MEMORY.ref(4, t6).offset(-0x58acL).setu(a0);
    a0 = a0 - a1;
    a0 = a0 - 0x40L;
    v1 = MEMORY.ref(4, s3).offset(0x90L).get();
    v0 = -0x9L;
    MEMORY.ref(2, s3).offset(0x7aL).setu(a0);
    a0 = -0x7L;
    MEMORY.ref(4, t6).offset(-0x58acL).setu(a2);
    v1 = v1 & v0;
    a3 = hi;
    v0 = a2 - a3;
    v0 = v0 >>> 1;
    a3 = a3 + v0;
    a3 = a3 >>> 6;
    v0 = a3 << 1;
    v0 = v0 + a3;
    v0 = v0 << 3;
    v0 = v0 + a3;
    v0 = v0 << 2;
    v0 = v0 + a3;
    v0 = a2 - v0;
    v0 = v0 < 0x32L ? 1 : 0;
    v0 = v0 ^ 0x1L;
    v0 = v0 << 3;
    v1 = v1 | v0;
    v0 = MEMORY.ref(2, s3).offset(0x84L).get();
    v1 = v1 & a0;
    MEMORY.ref(4, s3).offset(0x90L).setu(v1);
    v1 = MEMORY.ref(2, s3).offset(0x88L).get();
    v0 = v0 << 8;
    MEMORY.ref(2, s3).offset(0x84L).setu(v0);
    v0 = MEMORY.ref(2, s3).offset(0x86L).get();
    v1 = v1 << 8;
    MEMORY.ref(2, s3).offset(0x88L).setu(v1);
    v0 = v0 << 8;
    MEMORY.ref(2, s3).offset(0x86L).setu(v0);
    v0 = 0x8012_0000L;
    v0 = v0 - 0x6710L;
    s5 = t2 + v0;
    v1 = MEMORY.ref(1, s5).offset(0x0L).get();
    v0 = 0x2L;
    if(v1 == v0) {
      s7 = s0;
      //LAB_801018c8
      v0 = a2 + 0x1L;
      a0 = v0 << 5;
      a0 = a0 + v0;
      a0 = a0 << 2;
      a0 = a0 - v0;
      a0 = a0 << 2;
      a0 = a0 - v0;
      a0 = a0 << 2;
      a0 = a0 + v0;
      v0 = a0 << 5;
      a0 = a0 + v0;
      v1 = a0 + 0x1L;
      v0 = v1 << 5;
      v0 = v0 + v1;
      v0 = v0 << 2;
      v0 = v0 - v1;
      v0 = v0 << 2;
      v0 = v0 - v1;
      v0 = v0 << 2;
      v0 = v0 + v1;
      v1 = v0 << 5;
      s1 = MEMORY.ref(2, s6).offset(0x10L).get();
      v0 = v0 + v1;
      v1 = s1 & 0xffffL;
      v1 = v1 + 0x1L;
      hi = (v0 & 0xffff_ffffL) % (v1 & 0xffff_ffffL);
      s4 = hi;
      hi = (a0 & 0xffff_ffffL) * (t7 & 0xffff_ffffL) >>> 32;
      MEMORY.ref(4, t6).offset(-0x58acL).setu(v0);
      v1 = hi;
      v1 = v1 >>> 4;
      v0 = v1 << 12;
      v0 = v0 + v1;
      s2 = a0 - v0;
      a0 = s2;
      v0 = rcos(a0);
      lo = (long)(int)v0 * (int)s4 & 0xffff_ffffL;
      v0 = MEMORY.ref(2, s5).offset(0x2L).getSigned();
      a0 = s2;
      MEMORY.ref(2, s3).offset(0x52L).setu(0);
      v1 = lo;
      v0 = (int)v1 >> v0;
      MEMORY.ref(2, s3).offset(0x50L).setu(v0);
      v0 = rsin(a0);
      lo = (long)(int)v0 * (int)s4 & 0xffff_ffffL;
      v0 = MEMORY.ref(2, s5).offset(0x2L).getSigned();
      v1 = lo;
      v0 = (int)v1 >> v0;
      MEMORY.ref(2, s3).offset(0x54L).setu(v0);
    } else {
      s7 = s0;
      if((int)v1 >= 0x3L) {
        //LAB_80101824
        v0 = 0x3L;
        if(v1 == v0) {
          //LAB_80101990
          v1 = a2 + 0x1L;
          v0 = v1 << 5;
          v0 = v0 + v1;
          v0 = v0 << 2;
          v0 = v0 - v1;
          v0 = v0 << 2;
          v0 = v0 - v1;
          v0 = v0 << 2;
          v0 = v0 + v1;
          a0 = v0 << 5;
          v1 = MEMORY.ref(2, s5).offset(0x4L).getSigned();
          a1 = MEMORY.ref(2, s5).offset(0x2L).getSigned();
          v0 = v0 + a0;
          v1 = v1 - a1;
          v1 = v1 + 0x1L;
          hi = (v0 & 0xffff_ffffL) % (v1 & 0xffff_ffffL);
          a0 = hi;
          MEMORY.ref(4, t6).offset(-0x58acL).setu(v0);
          a0 = a0 + a1;
          MEMORY.ref(2, s3).offset(0x52L).setu(a0);
        } else {
          v0 = 0x4L;
          if(v1 == v0) {
            //LAB_801019e4
            v0 = a2 + 0x1L;
            a0 = v0 << 5;
            a0 = a0 + v0;
            a0 = a0 << 2;
            a0 = a0 - v0;
            a0 = a0 << 2;
            a0 = a0 - v0;
            a0 = a0 << 2;
            a0 = a0 + v0;
            v0 = a0 << 5;
            a0 = a0 + v0;
            hi = (a0 & 0xffff_ffffL) * (t7 & 0xffff_ffffL) >>> 32;
            a1 = 0x3f_0000L;
            a1 = a1 | 0xf801L;
            v1 = a0 + 0x1L;
            v0 = v1 << 5;
            v0 = v0 + v1;
            v0 = v0 << 2;
            v0 = v0 - v1;
            v0 = v0 << 2;
            v0 = v0 - v1;
            v0 = v0 << 2;
            v0 = v0 + v1;
            a2 = hi;
            v1 = v0 << 5;
            v0 = v0 + v1;
            hi = (v0 & 0xffff_ffffL) * (a1 & 0xffff_ffffL) >>> 32;
            s1 = MEMORY.ref(2, s6).offset(0x10L).get();
            MEMORY.ref(4, t6).offset(-0x58acL).setu(v0);
            a1 = a2 >>> 4;
            v1 = a1 << 12;
            v1 = v1 + a1;
            s2 = a0 - v1;
            t0 = hi;
            a0 = t0 >>> 1;
            v1 = a0 << 11;
            v1 = v1 + a0;
            s4 = v0 - v1;
            a0 = s2;
            v0 = rcos(a0);
            a0 = s4;
            s0 = v0;
            v0 = rsin(a0);
            lo = (long)(int)s0 * (int)v0 & 0xffff_ffffL;
            v0 = MEMORY.ref(2, s5).offset(0x2L).getSigned();
            v1 = lo;
            s1 = s1 & 0xffffL;
            v0 = (int)v1 >> v0;
            lo = (long)(int)v0 * (int)s1 & 0xffff_ffffL;
            a0 = s4;
            v0 = MEMORY.ref(2, s5).offset(0x4L).getSigned();
            v1 = lo;
            v0 = (int)v1 >> v0;
            MEMORY.ref(2, s3).offset(0x50L).setu(v0);
            v0 = rcos(a0);
            lo = (long)(int)v0 * (int)s1 & 0xffff_ffffL;
            a0 = s2;
            v0 = MEMORY.ref(2, s5).offset(0x4L).getSigned();
            v1 = lo;
            v0 = (int)v1 >> v0;
            MEMORY.ref(2, s3).offset(0x52L).setu(v0);
            v0 = rsin(a0);
            a0 = s4;
            s0 = v0;
            v0 = rsin(a0);
            lo = (long)(int)s0 * (int)v0 & 0xffff_ffffL;
            v0 = MEMORY.ref(2, s5).offset(0x2L).getSigned();
            v1 = lo;
            v0 = (int)v1 >> v0;
            lo = (long)(int)v0 * (int)s1 & 0xffff_ffffL;
            v0 = MEMORY.ref(2, s5).offset(0x4L).getSigned();

            //LAB_80101b04
            v1 = lo;
            v0 = (int)v1 >> v0;
            MEMORY.ref(2, s3).offset(0x54L).setu(v0);
          }
        }
      } else {
        v0 = 0x1L;
        if(v1 == v0) {
          //LAB_80101840
          v1 = a2 + 0x1L;
          v0 = v1 << 5;
          v0 = v0 + v1;
          v0 = v0 << 2;
          v0 = v0 - v1;
          v0 = v0 << 2;
          v0 = v0 - v1;
          v0 = v0 << 2;
          v0 = v0 + v1;
          v1 = v0 << 5;
          v0 = v0 + v1;
          hi = (v0 & 0xffff_ffffL) * (t7 & 0xffff_ffffL) >>> 32;
          s1 = MEMORY.ref(2, s6).offset(0x10L).get();
          MEMORY.ref(4, t6).offset(-0x58acL).setu(v0);
          v1 = hi;
          a0 = v1 >>> 4;
          v1 = a0 << 12;
          v1 = v1 + a0;
          s2 = v0 - v1;
          a0 = s2;
          v0 = rcos(a0);
          s0 = s1 & 0xffffL;
          lo = (long)(int)v0 * (int)s0 & 0xffff_ffffL;
          v0 = MEMORY.ref(2, s5).offset(0x2L).getSigned();
          a0 = s2;
          MEMORY.ref(2, s3).offset(0x52L).setu(0);
          v1 = lo;
          v0 = (int)v1 >> v0;
          MEMORY.ref(2, s3).offset(0x50L).setu(v0);
          v0 = rsin(a0);
          lo = (long)(int)v0 * (int)s0 & 0xffff_ffffL;
          v0 = MEMORY.ref(2, s5).offset(0x2L).getSigned();
          v1 = lo;
          v0 = (int)v1 >> v0;
          MEMORY.ref(2, s3).offset(0x54L).setu(v0);
        }
      }
    }

    //LAB_80101b10
    a1 = fp;
    a2 = s3;

    //LAB_80101b18
    a0 = sp3c;
    MEMORY.ref(4, a1).offset(0x8cL).deref(4).call(a0, a1, a2, s6);
    a0 = 0x8012_0000L;
    a0 = a0 - 0x6710L;
    v1 = s7 & 0xffffL;
    v0 = v1 << 2;
    v0 = v0 + v1;
    v0 = v0 << 1;
    a1 = v0 + a0;
    v0 = MEMORY.ref(1, a1).offset(0x6L).get();
    a2 = 0x1L;
    if(v0 == a2) {
      v0 = MEMORY.ref(2, s3).offset(0x58L).getSigned();
      v1 = MEMORY.ref(2, s6).offset(0x18L).get();
      lo = (long)(int)v0 * (int)v1 & 0xffff_ffffL;
      t0 = lo;
      v0 = MEMORY.ref(2, s3).offset(0x5aL).getSigned();
      lo = (long)(int)v0 * (int)v1 & 0xffff_ffffL;
      a0 = lo;
      v0 = MEMORY.ref(2, s3).offset(0x5cL).getSigned();
      lo = (long)(int)v0 * (int)v1 & 0xffff_ffffL;
      v0 = (int)t0 >> 8;
      MEMORY.ref(2, s3).offset(0x58L).setu(v0);
      v0 = (int)a0 >> 8;
      MEMORY.ref(2, s3).offset(0x5aL).setu(v0);
      v1 = lo;
      v0 = (int)v1 >> 8;
      MEMORY.ref(2, s3).offset(0x5cL).setu(v0);
    }

    //LAB_80101ba4
    v0 = MEMORY.ref(1, a1).offset(0x7L).get();

    if(v0 == a2) {
      a0 = 0x8010_0000L;
      v1 = MEMORY.ref(4, a0).offset(-0x58acL).get();
      v1 = v1 + 0x1L;
      v0 = v1 << 5;
      v0 = v0 + v1;
      v0 = v0 << 2;
      v0 = v0 - v1;
      v0 = v0 << 2;
      v0 = v0 - v1;
      v0 = v0 << 2;
      v0 = v0 + v1;
      v1 = v0 << 5;
      v0 = v0 + v1;
      MEMORY.ref(4, a0).offset(-0x58acL).setu(v0);
      v1 = MEMORY.ref(1, a1).offset(0x9L).getSigned();
      a0 = MEMORY.ref(1, a1).offset(0x8L).getSigned();
      v1 = v1 - a0;
      v1 = v1 + 0x1L;
      hi = (v0 & 0xffff_ffffL) % (v1 & 0xffff_ffffL);
      v1 = hi;
      v1 = v1 + a0;
      v1 = v1 << 24;
      v1 = (int)v1 >> 24;
      MEMORY.ref(2, s3).offset(0xaL).setu(v1);
      MEMORY.ref(2, s3).offset(0xcL).setu(v1);
    }

    //LAB_80101c20
    v0 = MEMORY.ref(2, s3).offset(0x50L).get();
    v1 = MEMORY.ref(2, s3).offset(0x52L).get();
    a0 = MEMORY.ref(2, s3).offset(0x54L).get();
    MEMORY.ref(2, s3).offset(0x48L).setu(v0);
    MEMORY.ref(2, s3).offset(0x4aL).setu(v1);
    MEMORY.ref(2, s3).offset(0x4cL).setu(a0);
  }

  @Method(0x80102534L)
  public static void FUN_80102534() {
    long s0 = _8011a00c.get();

    //LAB_80102550
    while(s0 != 0) {
      final long s1 = addToLinkedListHead(MEMORY.ref(4, s0).offset(0x64L).get());

      if(s1 != 0) {
        final long a1 = MEMORY.ref(4, s0).offset(0x68L).get();

        if(s1 < a1) {
          memcpy(s1, a1, (int)MEMORY.ref(4, s0).offset(0x64L).get());
          removeFromLinkedList(MEMORY.ref(4, s0).offset(0x68L).get());
          MEMORY.ref(4, s0).offset(0x68L).setu(s1);
        } else {
          //LAB_801025a4
          removeFromLinkedList(s1);
        }
      }

      //LAB_801025b0
      s0 = MEMORY.ref(4, s0).offset(0x94L).get();
    }

    //LAB_801025c0
  }

  @Method(0x80105f98L)
  public static void FUN_80105f98(final int scriptIndex, final VECTOR a1, long a2) {
    final MATRIX sp0x10 = new MATRIX();
    final VECTOR sp0x30 = new VECTOR();

    final BtldScriptData27c v0 = scriptStatePtrArr_800bc1c0.get(scriptIndex).deref().innerStruct_00.derefAs(BtldScriptData27c.class);

    final GsCOORDINATE2 coord2;
    if(a2 == 0) {
      coord2 = v0._148.coord2ArrPtr_04.deref().get(1);
    } else {
      //LAB_80105fe4
      coord2 = v0._148.coord2_14;
    }

    //LAB_80105fec
    GsGetLw(coord2, sp0x10);
    a1.set(ApplyMatrixLV(sp0x10, sp0x30)).add(sp0x10.transfer);
  }

  @Method(0x80106050L)
  public static void FUN_80106050(final long a0, final long a1) {
    final long callback = getMethodAddress(Bttl_800d.class, "FUN_800d46d4", Ref[].class);

    if(Math.abs((byte)a0) >= 0x2L) {
      FUN_800cff54(callback, 0x5L, 0x24L, 0x77L, 0x2bL, 0x1L, 0x80L);
      FUN_800cff54(callback, 0x5L, _800fb7bc.offset(1, 0x0L).offset(a1).get(), 0x73L, 0x30L, 0x1L, 0x80L);
    } else {
      //LAB_80106114
      FUN_800cff54(callback, 0x5L, 0x24L, 0x77L, 0x33L, 0x1L, 0x80L);
      FUN_800cff54(callback, 0x5L, _800fb7bc.offset(1, 0x2L).offset(a1).get(), 0x73L, 0x30L, 0x1L, 0x80L);
      FUN_800cff54(callback, 0x5L, 0x25L, 0x73L, 0x32L, 0x1L, 0x80L);
    }
  }

  @Method(0x801061bcL)
  public static long FUN_801061bc(final long a0, final long a1, final long a2, final long a3) {
    //LAB_80106264
    final long v0;
    if(a3 == 0x1L || a3 == 0x3L) {
      //LAB_80106274
      v0 = _800fb7c0.offset(a1 * 0x10L).offset(1, a2).get();
    } else {
      //LAB_8010628c
      v0 = FUN_800c7488(a0, a1, a2) & 0xffL;
    }

    //LAB_80106298
    return v0;
  }

  @Method(0x801062a8L)
  public static void FUN_801062a8(final int scriptIndex, final long a1, final BttlScriptData6cSub44 a2, final long a3) {
    long v0;
    long s3;
    long s6;
    long s7;
    long s5 = scriptStatePtrArr_800bc1c0.get(scriptIndex).deref().innerStruct_00.getPointer();

    //LAB_8010633c
    for(s3 = 0; s3 < 8; s3++) {
      if((FUN_801061bc(MEMORY.ref(2, s5).offset(0x276L).getSigned(), s3, 0x1L, a3) & 0xffL) == 0) {
        break;
      }
    }

    //LAB_80106374
    v0 = s3 - 0x1L;
    a2._30.set((int)v0);
    a2.scriptIndex_00.set(scriptIndex);
    a2.scriptIndex_04.set(a1);
    a2._34.set((short)0);
    a2._31.set(0);
    a2._32.set(0);
    a2._38.set(0);
    a2._39.set(0);
    a2._3a.set((int)a3);
    a2._40.set(addToLinkedListTail((v0 & 0xffL) * 0x20L));
    s6 = FUN_801061bc(MEMORY.ref(2, s5).offset(0x276L).getSigned(), 0, 0xfL, a3) & 0xffL;
    a2._36.set((int)s6);

    s7 = a2._40.get();

    //LAB_801063f0
    for(s3 = 0; s3 < a2._30.get(); s3++) {
      MEMORY.ref(1, s7).offset(0x0L).setu(0x1L);
      MEMORY.ref(1, s7).offset(0x1L).setu(0);
      MEMORY.ref(2, s7).offset(0x8L).setu(0);
      MEMORY.ref(2, s7).offset(0x10L).setu(s6 + 0x2L);
      _800fa754.setu((_800fa754.get() + 0x1L) * 0x10dcdL);
      MEMORY.ref(1, s7).offset(0x2L).setu(0x3L);
      MEMORY.ref(1, s7).offset(0x1cL).setu(0);
      _8011a014.offset(s3).offset(1, 0x0L).setu(0);
      v0 = FUN_801061bc(MEMORY.ref(2, s5).offset(0x276L).getSigned(), s3, 0x1L, a3) & 0xffL;
      s6 = s6 + v0;
      MEMORY.ref(2, s7).offset(0xaL).setu(v0);
      v0 = FUN_801061bc(MEMORY.ref(2, s5).offset(0x276L).getSigned(), s3, 0x2L, a3) & 0xffL;
      MEMORY.ref(2, s7).offset(0xcL).setu(v0);
      v0 = FUN_801061bc(MEMORY.ref(2, s5).offset(0x276L).getSigned(), s3, 0x3L, a3) & 0xffL;
      MEMORY.ref(2, s7).offset(0xeL).setu(v0);
      long a3_0 = MEMORY.ref(2, s7).offset(0x10L).get() + MEMORY.ref(2, s7).offset(0xcL).get();
      MEMORY.ref(2, s7).offset(0x10L).setu(a3_0 - (short)v0 / 2 + 1);
      MEMORY.ref(2, s7).offset(0x12L).setu(a3_0 + v0 - (short)MEMORY.ref(2, s7).offset(0xeL).get() / 2);

      a3_0 = addToLinkedListTail(0xeeL);
      MEMORY.ref(4, s7).offset(0x18L).setu(a3_0);

      //LAB_8010652c
      for(int i = 16; i >= 0; i--) {
        MEMORY.ref(2, a3_0).offset(0x8L).setu((18 - i) * 10);
        MEMORY.ref(1, a3_0).offset(0x0L).setu(0x1L);
        //LAB_8010656c
        //LAB_80106574
        MEMORY.ref(2, a3_0).offset(0x2L).setu((16 - i) * 0x80 + 0x200L);
        MEMORY.ref(1, a3_0).offset(0xcL).setu(0x5L);
        MEMORY.ref(1, a3_0).offset(0xdL).setu(0);
        MEMORY.ref(2, a3_0).offset(0xaL).setu(MEMORY.ref(2, s7).offset(0x10L).get() + (MEMORY.ref(2, s7).offset(0xeL).getSigned() - 0x1L) / 2 + i - 0x11L);
        MEMORY.ref(1, a3_0).offset(0x4L).setu(_800fb7f0.offset(1, MEMORY.ref(1, s7).offset(0x2L).getSigned() * 3).offset(0x0L).get());
        MEMORY.ref(1, a3_0).offset(0x5L).setu(_800fb7f0.offset(1, MEMORY.ref(1, s7).offset(0x2L).getSigned() * 3).offset(0x1L).get());
        MEMORY.ref(1, a3_0).offset(0x6L).setu(_800fb7f0.offset(1, MEMORY.ref(1, s7).offset(0x2L).getSigned() * 3).offset(0x2L).get());
        a3_0 = a3_0 + 0xeL;
      }

      a3_0 = a3_0 - 0xeL;

      //LAB_80106634
      for(int i = 0; i < 3; i++) {
        MEMORY.ref(2, a3_0).offset(0x8L).setu(0x14L - i * 0x2L);
        MEMORY.ref(1, a3_0).offset(0x0L).setu(0x1L);
        MEMORY.ref(2, a3_0).offset(0x2L).setu(0x200L);
        MEMORY.ref(1, a3_0).offset(0xcL).setu(0x11L);
        MEMORY.ref(1, a3_0).offset(0xdL).setu(0x1L);
        MEMORY.ref(2, a3_0).offset(0xaL).setu(MEMORY.ref(2, s7).offset(0x10L).get() - 0x11L);

        if(i != 0x1L) {
          MEMORY.ref(1, a3_0).offset(0x4L).setu(0x30L);
          MEMORY.ref(1, a3_0).offset(0x5L).setu(0x30L);
          MEMORY.ref(1, a3_0).offset(0x6L).setu(0x30L);
        } else {
          //LAB_80106680
          MEMORY.ref(1, a3_0).offset(0xdL).setu(0xffL);
        }

        //LAB_80106684
        a3_0 = a3_0 - 0xeL;
      }

      MEMORY.ref(4, s7).offset(0x14L).setu(a3_0);
      s7 = s7 + 0x20L;
    }

    //LAB_801066c8
    FUN_80105f98((int)a2.scriptIndex_00.get(), MEMORY.ref(4, a2.getAddress() + 0x10L, VECTOR::new), 0); //TODO

    final VECTOR sp0x10 = new VECTOR();
    FUN_80105f98((int)a2.scriptIndex_04.get(), sp0x10, 0x1L);

    final int a0_0 = (int)MEMORY.ref(4, a2._40.get()).offset(0x10L).getSigned();
    //TODO
    MEMORY.ref(4, a2.getAddress()).offset(0x20L).setu(sp0x10.getX() - MEMORY.ref(4, a2.getAddress()).offset(0x10L).getSigned() / a0_0);
    MEMORY.ref(4, a2.getAddress()).offset(0x24L).setu(sp0x10.getY() - MEMORY.ref(4, a2.getAddress()).offset(0x14L).getSigned() / a0_0);
    MEMORY.ref(4, a2.getAddress()).offset(0x28L).setu(sp0x10.getZ() - MEMORY.ref(4, a2.getAddress()).offset(0x18L).getSigned() / a0_0);
  }

  @Method(0x80106774L)
  public static long FUN_80106774(final long a0, final long a1) {
    long v1 = 0;
    long v0 = MEMORY.ref(1, a0).offset(0x4L).get() - a1;
    final long sp10;
    if((int)v0 > 0) {
      sp10 = v0;
    } else {
      sp10 = 0;
      v1++;
    }

    //LAB_801067b0
    v0 = MEMORY.ref(1, a0).offset(0x5L).get() - a1;
    final long sp14;
    if((int)v0 > 0) {
      sp14 = v0;
    } else {
      sp14 = 0;
      v1++;
    }

    //LAB_801067c4
    v0 = MEMORY.ref(1, a0).offset(0x6L).get() - a1;
    final long sp18;
    if((int)v0 > 0) {
      sp18 = v0;
    } else {
      sp18 = 0;
      v1++;
    }

    //LAB_801067d8
    MEMORY.ref(1, a0).offset(0x4L).setu(sp10);
    MEMORY.ref(1, a0).offset(0x5L).setu(sp14);
    MEMORY.ref(1, a0).offset(0x6L).setu(sp18);
    return v1;
  }

  @Method(0x80106808L)
  public static void FUN_80106808(final BttlScriptData6cSubBase1 a0, long a1, long a2, ScriptState<BttlScriptData6c> a3, final BttlScriptData6c a4) {
    long v0;
    long t0;
    long s1;
    long s3;
    long s4;
    long s5;

    if((int)a4._10._00.get() >= 0) {
      long s6 = a2;
      v0 = MEMORY.ref(4, a1).offset(0x14L).get();
      s4 = v0 + 0x1cL;

      //LAB_8010685c
      for(s5 = 0; s5 < 2; s5++) {
        s1 = 0;
        s3 = MEMORY.ref(2, s4).offset(0x8L).getSigned() - s5 * 0x8L;

        //LAB_80106874
        final long[] sp0x18 = new long[8];
        for(int i = 0; i < 4; i++) {
          v0 = rcos(MEMORY.ref(2, s4).offset(0x2L).getSigned() + s1);
          t0 = (long)(int)v0 * (int)s3 & 0xffff_ffffL;
          v0 = (int)t0 >> 12;
          sp0x18[i] = v0;
          v0 = rsin(MEMORY.ref(2, s4).offset(0x2L).getSigned() + s1);
          t0 = (long)(int)v0 * (int)s3 & 0xffff_ffffL;
          v0 = (int)t0 >> 12;
          sp0x18[i + 1] = v0 + 0x1eL;
          s1 = s1 + 0x400L;
        }

        final long addr = linkedListAddress_1f8003d8.get();
        linkedListAddress_1f8003d8.addu(0x18L);
        MEMORY.ref(4, addr).offset(0x4L).setu(0x2880_8080L);
        MEMORY.ref(1, addr).offset(0x3L).setu(0x5L);
        v0 = MEMORY.ref(1, addr).offset(0x7L).get() | 0x2L;
        v0 = v0 << 24;
        v0 = v0 | 0x80_8080L;
        MEMORY.ref(4, addr).offset(0x4L).setu(v0);
        if(s6 == 0x1L) {
          MEMORY.ref(1, addr).offset(0x4L).setu(0xffL);
          MEMORY.ref(1, addr).offset(0x5L).setu(0xffL);
          MEMORY.ref(1, addr).offset(0x6L).setu(0xffL);
          //LAB_80106918
        } else if(s6 != -0x2L) {
          //LAB_80106988
          MEMORY.ref(1, addr).offset(0x4L).setu(0x30L);
          MEMORY.ref(1, addr).offset(0x5L).setu(0x30L);
          MEMORY.ref(1, addr).offset(0x6L).setu(0x30L);
        } else if(MEMORY.ref(1, a1).offset(0x1cL).getSigned() != 0) {
          MEMORY.ref(1, addr).offset(0x4L).setu(MEMORY.ref(1, s4).offset(-0xaL).get() * 3);
          MEMORY.ref(1, addr).offset(0x5L).setu(MEMORY.ref(1, s4).offset(-0x9L).get());
          MEMORY.ref(1, addr).offset(0x6L).setu((MEMORY.ref(1, s4).offset(-0x8L).get() - 0x1L) * 0x8L);
        } else {
          //LAB_80106964
          MEMORY.ref(1, addr).offset(0x4L).setu(MEMORY.ref(1, s4).offset(-0xaL).get());
          MEMORY.ref(1, addr).offset(0x5L).setu(MEMORY.ref(1, s4).offset(-0x9L).get());
          MEMORY.ref(1, addr).offset(0x6L).setu(MEMORY.ref(1, s4).offset(-0x8L).get());
        }

        //LAB_80106994
        MEMORY.ref(2, addr).offset(0x8L).setu(sp0x18[0]);
        MEMORY.ref(2, addr).offset(0xaL).setu(sp0x18[1]);
        MEMORY.ref(2, addr).offset(0xcL).setu(sp0x18[2]);
        MEMORY.ref(2, addr).offset(0xeL).setu(sp0x18[3]);
        MEMORY.ref(2, addr).offset(0x10L).setu(sp0x18[6]);
        MEMORY.ref(2, addr).offset(0x12L).setu(sp0x18[7]);
        MEMORY.ref(2, addr).offset(0x14L).setu(sp0x18[4]);
        MEMORY.ref(2, addr).offset(0x16L).setu(sp0x18[5]);
        insertElementIntoLinkedList(tags_1f8003d0.getPointer() + 0x78L, addr);
        a2 = 0;
      }

      SetDrawMode(linkedListAddress_1f8003d8.deref(4).cast(DR_MODE::new), false, true, GetTPage(0x1L, 0x1L, a2, a2), null);
      insertElementIntoLinkedList(tags_1f8003d0.getPointer() + 0x78L, linkedListAddress_1f8003d8.get());
      linkedListAddress_1f8003d8.addu(0xcL);
    }

    //LAB_80106a4c
  }

  @Method(0x80106ac4L)
  public static void FUN_80106ac4(long a0, long a1, long a2) {
    long v0;
    long s0;
    long s2;
    s2 = a1 + 0x400L;
    s0 = a2 - 0x1L;
    long sp10 = rcos(a1) * s0 >> 12;
    long sp14 = rsin(a1) * s0 >> 12;
    long sp18 = rcos(s2) * s0 >> 12;
    long sp1c = rsin(s2) * s0 >> 12;
    s0 = a2 - 0xbL;
    long sp20 = rcos(a1) * s0 >> 12;
    long sp24 = rsin(a1) * s0 >> 12;
    long sp28 = rcos(s2) * s0 >> 12;
    long sp2c = rsin(s2) * s0 >> 12;
    final long a1_0 = linkedListAddress_1f8003d8.get();
    linkedListAddress_1f8003d8.addu(0x24L);
    MEMORY.ref(4, a1_0).offset(0x4L).setu(0x3880_8080L);
    MEMORY.ref(1, a1_0).offset(0x3L).setu(0x8L);
    MEMORY.ref(1, a1_0).offset(0x14L).setu(0);
    MEMORY.ref(1, a1_0).offset(0x15L).setu(0);
    MEMORY.ref(1, a1_0).offset(0x16L).setu(0);
    MEMORY.ref(1, a1_0).offset(0x1cL).setu(0);
    MEMORY.ref(1, a1_0).offset(0x1dL).setu(0);
    MEMORY.ref(1, a1_0).offset(0x1eL).setu(0);
    v0 = MEMORY.ref(1, a1_0).offset(0x7L).get() | 0x2L;
    v0 = v0 << 24;
    v0 = v0 | 0x80_8080L;
    final long a0_0 = MEMORY.ref(2, a0).offset(0x8L).getSigned() * 0x4L;
    MEMORY.ref(4, a1_0).offset(0x4L).setu(v0);
    MEMORY.ref(1, a1_0).offset(0x4L).setu(a0_0);
    MEMORY.ref(1, a1_0).offset(0x5L).setu(a0_0);
    MEMORY.ref(1, a1_0).offset(0x6L).setu(a0_0);
    MEMORY.ref(1, a1_0).offset(0xcL).setu(a0_0);
    MEMORY.ref(1, a1_0).offset(0xdL).setu(a0_0);
    MEMORY.ref(1, a1_0).offset(0xeL).setu(a0_0);
    MEMORY.ref(2, a1_0).offset(0x8L).setu(sp10);
    MEMORY.ref(2, a1_0).offset(0xaL).setu(sp14 + 0x1eL);
    MEMORY.ref(2, a1_0).offset(0x10L).setu(sp18);
    MEMORY.ref(2, a1_0).offset(0x12L).setu(sp1c + 0x1eL);
    MEMORY.ref(2, a1_0).offset(0x18L).setu(sp20);
    MEMORY.ref(2, a1_0).offset(0x1aL).setu(sp24 + 0x1eL);
    MEMORY.ref(2, a1_0).offset(0x20L).setu(sp28);
    MEMORY.ref(2, a1_0).offset(0x22L).setu(sp2c + 0x1eL);
    insertElementIntoLinkedList(tags_1f8003d0.getPointer() + 0x7cL, a1_0);
  }

  @Method(0x80106cccL)
  public static void FUN_80106ccc(final long a0, final long a1, final BttlScriptData6cSubBase1 a2, final long a3, final ScriptState<BttlScriptData6c> a4) {
    long s7 = MEMORY.ref(4, a3).offset(0x18L).get();
    long sp28 = _8011a014.offset(a1).getAddress();
    long s3 = s7 + 0x2L;

    //LAB_80106d18
    for(long s6 = 0; s6 < 17; s6++) {
      if(MEMORY.ref(1, s7).offset(0x0L).getSigned() != 0) {
        if(MEMORY.ref(2, s3).offset(0x8L).getSigned() <= 0) {
          long s2 = MEMORY.ref(2, s3).offset(0x6L).getSigned();
          long sp20 = rcos(MEMORY.ref(2, s3).offset(0x0L).getSigned()) * s2 >> 12;
          long sp24 = (rsin(MEMORY.ref(2, s3).offset(0x0L).getSigned()) * s2 >> 12) + 0x1eL;

          //LAB_80106d80
          long s4 = 0;
          for(long s5 = 0; s5 < 4; s5++) {
            long s1 = linkedListAddress_1f8003d8.get();
            linkedListAddress_1f8003d8.addu(0x10L);
            MEMORY.ref(1, s1).offset(0x3L).setu(0x3L);
            MEMORY.ref(4, s1).offset(0x4L).setu(0x4080_8080L);
            long v1 = MEMORY.ref(1, s3).offset(0xbL).get();

            //LAB_80106dc0
            long v0;
            if(v1 != 0 && v1 != 0xffL || MEMORY.ref(1, sp28).offset(0x0L).getSigned() < 0) {
              //LAB_80106de8
              v0 = MEMORY.ref(1, s1).offset(0x7L).get() | 0x2L;
            } else {
              v0 = MEMORY.ref(1, s1).offset(0x7L).get() & 0xfdL;
            }

            //LAB_80106df4
            MEMORY.ref(4, s1).offset(0x4L).setu(v0 << 24 | 0x80_8080L);

            if(MEMORY.ref(1, a3).offset(0x1cL).getSigned() != 0 && s6 != 0x10L) {
              MEMORY.ref(1, s1).offset(0x4L).setu(MEMORY.ref(1, s3).offset(0x2L).get() * 3);
              MEMORY.ref(1, s1).offset(0x5L).setu(MEMORY.ref(1, s3).offset(0x3L).get());
              MEMORY.ref(1, s1).offset(0x6L).setu((MEMORY.ref(1, s3).offset(0x4L).get() + 1) / 8);
            } else {
              //LAB_80106e58
              MEMORY.ref(1, s1).offset(0x4L).setu(MEMORY.ref(1, s3).offset(0x2L).get());
              MEMORY.ref(1, s1).offset(0x5L).setu(MEMORY.ref(1, s3).offset(0x3L).get());
              MEMORY.ref(1, s1).offset(0x6L).setu(MEMORY.ref(1, s3).offset(0x4L).get());
            }

            //LAB_80106e74
            s4 = s4 + 0x400L;
            long sp18 = rcos(MEMORY.ref(2, s3).offset(0x0L).getSigned() + s4) * s2 >> 12;
            long sp1c = (rsin(MEMORY.ref(2, s3).offset(0x0L).getSigned() + s4) * s2 >> 12) + 0x1eL;
            MEMORY.ref(2, s1).offset(0x8L).setu(sp20);
            MEMORY.ref(2, s1).offset(0xaL).setu(sp24);
            MEMORY.ref(2, s1).offset(0xcL).setu(sp18);
            MEMORY.ref(2, s1).offset(0xeL).setu(sp1c);
            insertElementIntoLinkedList(tags_1f8003d0.getPointer() + 0x78L, s1);
            sp20 = sp18;
            sp24 = sp1c;
          }

          if(MEMORY.ref(1, s3).offset(0xbL).get() == 0) {
            FUN_80106ac4(a3, MEMORY.ref(2, s3).offset(0x0L).get() + s4         , s2);
            FUN_80106ac4(a3, MEMORY.ref(2, s3).offset(0x0L).get() + s4 + 0x400L, s2);
            FUN_80106ac4(a3, MEMORY.ref(2, s3).offset(0x0L).get() + s4 + 0x800L, s2);
            FUN_80106ac4(a3, MEMORY.ref(2, s3).offset(0x0L).get() + s4 + 0xc00L, s2);
          }
        }
      }

      //LAB_80106fac
      s3 = s3 + 0xeL;
      s7 = s7 + 0xeL;
    }

    SetDrawMode(linkedListAddress_1f8003d8.deref(4).cast(DR_MODE::new), false, true, GetTPage(0x1L, 0x1L, 0, 0), null);
    insertElementIntoLinkedList(tags_1f8003d0.getPointer() + 0x78L, linkedListAddress_1f8003d8.get());
    linkedListAddress_1f8003d8.addu(0xcL);

    SetDrawMode(linkedListAddress_1f8003d8.deref(4).cast(DR_MODE::new), false, true, GetTPage(0x1L, 0x2L, 0, 0), null);
    insertElementIntoLinkedList(tags_1f8003d0.getPointer() + 0x7cL, linkedListAddress_1f8003d8.get());
    linkedListAddress_1f8003d8.addu(0xcL);
  }

  @Method(0x80107088L)
  public static long FUN_80107088(final long a0, final long a1, final BttlScriptData6cSub44 a2, final long a3) {
    long v0;
    long v1;
    long s0;
    long s1;
    long s2;
    long s4;
    long s5;
    v1 = a2._34.get();
    v0 = MEMORY.ref(2, a3).offset(0x10L).getSigned() - 0x11L;
    s4 = 0;
    if((int)v1 >= (int)v0) {
      v0 = MEMORY.ref(2, a3).offset(0x8L).get() + 0x1L;
      MEMORY.ref(2, a3).offset(0x8L).setu(v0);
      v0 = v0 << 16;
      v0 = (int)v0 >> 16;
      if((int)v0 >= 0xeL) {
        MEMORY.ref(2, a3).offset(0x8L).setu(0xdL);
      }
    }

    //LAB_801070ec
    s1 = MEMORY.ref(4, a3).offset(0x18L).get();
    s2 = 0;
    v0 = 0x8012_0000L;
    v0 = v0 - 0x5fecL;
    s5 = a1 + v0;
    s0 = s1 + 0xcL;

    //LAB_80107104
    do {
      v0 = MEMORY.ref(1, s5).offset(0x0L).getSigned();

      if((int)v0 < 0) {
        v0 = MEMORY.ref(2, a3).offset(0x8L).get() - 0x3L;
        MEMORY.ref(2, a3).offset(0x8L).setu(v0);
        v0 = v0 << 16;
        if((int)v0 < 0) {
          MEMORY.ref(2, a3).offset(0x8L).setu(0);
        }

        //LAB_80107134
        if(FUN_80106774(s1, 0x20L) == 0x3L) {
          MEMORY.ref(1, s1).offset(0x0L).setu(0);
        }
      }

      //LAB_80107150
      if(MEMORY.ref(1, s1).offset(0x0L).getSigned() != 0) {
        v0 = MEMORY.ref(2, s0).offset(-0x2L).getSigned();
        v1 = MEMORY.ref(2, s0).offset(-0x2L).get();
        if((int)v0 > 0) {
          v0 = v1 - 0x1L;
          MEMORY.ref(2, s0).offset(-0x2L).setu(v0);
        } else {
          //LAB_80107178
          v1 = MEMORY.ref(1, s0).offset(0x1L).get();
          s4 = 0x1L;
          if(v1 != 0xffL) {
            v0 = v1 + 0x1L;
            MEMORY.ref(1, s0).offset(0x1L).setu(v0);
          }

          //LAB_80107190
          v0 = MEMORY.ref(1, s0).offset(0x0L).get() - 0x1L;
          MEMORY.ref(1, s0).offset(0x0L).setu(v0);
          v0 = v0 << 24;
          if(v0 == 0) {
            MEMORY.ref(1, s1).offset(0x0L).setu(0);
          }

          //LAB_801071b0
          if((int)s2 < 0xeL) {
            FUN_80106774(s1, 0x4eL);
          }
        }
      }

      //LAB_801071c0
      s2 = s2 + 0x1L;
      s0 = s0 + 0xeL;
      s1 = s1 + 0xeL;
    } while((int)s2 < 0x11L);

    return s4;
  }

  @Method(0x801071fcL)
  public static void FUN_801071fc(final BttlScriptData6cSub44 a0, long a1, long a2) {
    long v0;
    long a3;
    long t0;
    v0 = 0x8012_0000L;
    t0 = v0 - 0x5fecL;
    v0 = a2 + t0;
    a3 = MEMORY.ref(1, v0).offset(0x0L).getSigned();
    a0._32.set(1);

    a1 = a1 + 0x20L + 0xcL;

    //LAB_80107234
    a2 = a2 + 0x1L;
    for(; a2 < a0._30.get(); a2++) {
      v0 = a2 + t0;
      MEMORY.ref(2, a1).offset(0x6L).setu(-0x1L);
      MEMORY.ref(2, a1).offset(0x4L).setu(-0x1L);
      MEMORY.ref(2, a1).offset(0x2L).setu(0);
      MEMORY.ref(2, a1).offset(0x0L).setu(0);
      MEMORY.ref(1, v0).offset(0x0L).setu(a3);
      a1 = a1 + 0x20L;
    }

    //LAB_80107264
  }

  @Method(0x8010726cL)
  public static void FUN_8010726c(final int index, final ScriptState<BttlScriptData6c> state, final BttlScriptData6c data) {
    long v1;
    long s0;
    long s1;
    final BttlScriptData6cSub44 s2 = data._44.derefAs(BttlScriptData6cSub44.class);

    if(s2._31.get() != 0x1L) {
      if((int)data._10._00.get() >= 0) {
        s1 = s2._40.get();

        //LAB_801072c4
        for(s0 = 0; s0 < s2._30.get(); s0++) {
          FUN_80106ccc(MEMORY.ref(1, s1).offset(0x2L).getSigned(), s0, s2, s1, state);
          s1 = s1 + 0x20L;
        }

        //LAB_801072f4
        s1 = s2._40.get();

        //LAB_8010730c
        for(s0 = 0; s0 < s2._30.get(); s0++) {
          if(_8011a014.offset(1, s0).getSigned() == 0) {
            break;
          }

          s1 = s1 + 0x20L;
        }

        //LAB_80107330
        if((int)s0 < s2._30.get()) {
          FUN_80106050((byte)(MEMORY.ref(2, s1).offset(0x10L).getSigned() + (MEMORY.ref(2, s1).offset(0x12L).getSigned() - MEMORY.ref(2, s1).offset(0x10L).getSigned()) / 2 - s2._34.get() - 0x1L), MEMORY.ref(1, s1).offset(0x1cL).getSigned());

          v1 = (byte)s2._34.get();
          if(MEMORY.ref(2, s1).offset(0x10L).getSigned() <= (int)v1 && MEMORY.ref(2, s1).offset(0x12L).getSigned() >= (int)v1) {
            FUN_80106808(s2, s1, -0x2L, state, data);
          }
        }
      }
    }

    //LAB_801073b4
  }

  @Method(0x801073d4L)
  public static void FUN_801073d4(final int index, final ScriptState<BttlScriptData6c> state, final BttlScriptData6c data) {
    long v0;
    long v1;
    long a0;
    long s0;
    long s1;
    long s2;
    long s4;
    final BttlScriptData6cSub44 s3 = data._44.derefAs(BttlScriptData6cSub44.class);

    if(s3._31.get() == 0) {
      s4 = 0x1L;
      s2 = s3._40.get();
      s3._34.incr();
      v0 = 0x8012_0000L;
      s1 = v0 - 0x5fecL;

      //LAB_80107440
      for(s0 = 0; s0 < s3._30.get(); s0++) {
        if(s3._34.get() != MEMORY.ref(2, s2).offset(0x12L).getSigned() + 0x1L) {
          if(MEMORY.ref(1, s1).offset(0x0L).getSigned() == 0) {
            s4 = 0;
          }
        } else {
          if(MEMORY.ref(1, s1).offset(0x0L).getSigned() == 0) {
            MEMORY.ref(1, s1).offset(0x0L).setu(-0x2L);
            FUN_801071fc(s3, s2, s0);

            //LAB_80107478
            if(MEMORY.ref(1, s1).offset(0x0L).getSigned() == 0) {
              s4 = 0;
            }
          }
        }

        //LAB_8010748c
        s1 = s1 + 0x1L;
        s2 = s2 + 0x20L;
      }

      //LAB_801074a8
      if(s4 != 0) {
        FUN_801071fc(s3, s2, s0);
      }

      //LAB_801074bc
      s1 = 0;
      s2 = s3._40.get();

      //LAB_801074d0
      for(s0 = 0; s0 < s3._30.get(); s0++) {
        v0 = FUN_80107088(MEMORY.ref(1, s2).offset(0x2L).getSigned(), s0, s3, s2);
        s1 = s1 + v0;
        s2 = s2 + 0x20L;
      }

      //LAB_80107500
      if(s1 == 0 && s3._32.get() != 0) {
        v0 = 0x8012_0000L;
        MEMORY.ref(1, v0).offset(-0x60bfL).setu(0);
        s2 = s3._40.get();

        //LAB_8010752c
        for(s0 = 0; s0 < s3._30.get(); s0++) {
          a0 = MEMORY.ref(4, s2).offset(0x18L).get();
          removeFromLinkedList(a0);
          s2 = s2 + 0x20L;
        }

        //LAB_80107554
        FUN_80015d38(index);
      } else {
        //LAB_8010756c
        v0 = s3._34.get();

        if((int)v0 >= 0x9L) {
          s2 = s3._40.get();

          if(s3._30.get() != 0) {
            //LAB_80107598
            for(s0 = 0; s0 < s3._30.get(); s0++) {
              if(_8011a014.offset(s0).getSigned() == 0) {
                break;
              }

              s2 = s2 + 0x20L;
            }

            //LAB_801075bc
            if((int)s0 < s3._30.get()) {
              if(state.storage_44.get(8).get() != 0) {
                MEMORY.ref(1, s2).offset(0x1cL).setu(0x1L);
                state.storage_44.get(8).set(0);
              }

              //LAB_801075e8
              v0 = s3._3a.get() - 0x1L;
              if(v0 >= 0x2L) {
                v1 = s3._3a.get() & 0xffL;
                //LAB_8010763c
                if(v1 != 0x1) {
                  if(v1 != 0x3L) {
                    if(MEMORY.ref(1, s2).offset(0x1cL).getSigned() == 0) {
                      a0 = 0x2L;
                    } else {
                      a0 = 0x4L;
                    }

                    //LAB_80107664
                    v0 = 0x8008_0000L;
                    v0 = MEMORY.ref(4, v0).offset(-0x5c68L).get();

                    v1 = v0 >>> 4;
                    v0 = v1 & 0x6L;
                    if(v0 != 0) {
                      _8011a014.offset(1, s0).offset(0x0L).setu(-0x1L);
                      if((v1 & a0) == 0 || (v1 & ~a0) != 0) {
                        //LAB_801076d8
                        //LAB_801076dc
                        v0 = 0x8012_0000L;
                        v0 = v0 - 0x5fecL;
                        v0 = s0 + v0;
                        MEMORY.ref(1, v0).offset(0x0L).setu(-0x3L);
                      } else {
                        v1 = s3._34.get();

                        if((int)v1 >= MEMORY.ref(2, s2).offset(0x10L).getSigned() && (int)v1 <= MEMORY.ref(2, s2).offset(0x12L).getSigned()) {
                          _8011a014.offset(1, s0).offset(0x0L).setu(0x1L);
                          MEMORY.ref(1, s2).offset(0x1L).setu(0x1L);
                        }
                      }

                      //LAB_801076f0
                      v0 = 0x8012_0000L;
                      v0 = v0 - 0x5fecL;
                      v0 = s0 + v0;
                      v0 = MEMORY.ref(1, v0).offset(0x0L).getSigned();

                      if((int)v0 < 0) {
                        FUN_801071fc(s3, s2, s0);
                      }

                      //LAB_80107718
                      //LAB_8010771c
                      s3._38.set(2);
                      s3._39.set((int)s0);
                      s3._3c.set(s2);
                    }
                  }
                }
              } else {
                v1 = s3._34.get();

                if((int)v1 >= MEMORY.ref(2, s2).offset(0x10L).getSigned() && (int)v1 <= MEMORY.ref(2, s2).offset(0x12L).getSigned()) {
                  v1 = _8011a014.offset(s0).getAddress();
                  MEMORY.ref(1, v1).offset(0x0L).setu(0x1L);
                  MEMORY.ref(1, s2).offset(0x1L).setu(0x1L);
                  s3._38.set(2);
                  s3._39.set((int)s0);
                  s3._3c.set(s2);
                }
              }
            }
          }

          //LAB_80107728
          if(s3._38.get() != 0) {
            s3._38.decr();
            v0 = 0x8012_0000L;
            v0 = v0 - 0x5fecL;
            v1 = s3._39.get() + v0;
            FUN_80106808(s3, s3._3c.get(), MEMORY.ref(1, v1).offset(0x0L).getSigned(), state, data);
          }
        }
      }
    }

    //LAB_80107764
  }

  @Method(0x80107790L)
  public static void FUN_80107790(final int index, final ScriptState<BttlScriptData6c> state, final BttlScriptData6c data) {
    assert false;
  }

  @Method(0x801077e8L)
  public static long FUN_801077e8(final RunningScript s1) {
    final long s2 = FUN_800e80c4(
      s1.scriptStateIndex_00.get(),
      0x44L,
      MEMORY.ref(4, getMethodAddress(SEffe.class, "FUN_801073d4", int.class, ScriptState.classFor(BttlScriptData6c.class), BttlScriptData6c.class), TriConsumerRef::new),
      MEMORY.ref(4, getMethodAddress(SEffe.class, "FUN_8010726c", int.class, ScriptState.classFor(BttlScriptData6c.class), BttlScriptData6c.class), TriConsumerRef::new),
      MEMORY.ref(4, getMethodAddress(SEffe.class, "FUN_80107790", int.class, ScriptState.classFor(BttlScriptData6c.class), BttlScriptData6c.class), TriConsumerRef::new),
      BttlScriptData6cSub44::new
    );

    final ScriptState<BttlScriptData6c> v0 = scriptStatePtrArr_800bc1c0.get((int)s2).derefAs(ScriptState.classFor(BttlScriptData6c.class));
    FUN_801062a8((int)s1.params_20.get(0).deref().get(), s1.params_20.get(1).deref().get(), v0.innerStruct_00.deref()._44.derefAs(BttlScriptData6cSub44.class), s1.params_20.get(2).deref().get());
    v0.storage_44.get(8).set(0);
    s1.params_20.get(4).deref().set(s2);
    _80119f41.setu(0x1L);
    return 0;
  }

  @Method(0x80110030L)
  public static VECTOR FUN_80110030(final int scriptIndex) {
    final long a0 = scriptStatePtrArr_800bc1c0.get(scriptIndex).deref().innerStruct_00.getPointer(); //TODO

    if(MEMORY.ref(4, a0).offset(0x0L).get() == 0x2020_4d45L) {
      return MEMORY.ref(4, a0 + 0x14L, VECTOR::new);
    }

    //LAB_8011006c
    return MEMORY.ref(4, a0 + 0x174L, VECTOR::new);
  }

  @Method(0x80110074L)
  public static SVECTOR FUN_80110074(final long a0) {
    final long data = scriptStatePtrArr_800bc1c0.get((int)a0).deref().innerStruct_00.getPointer(); //TODO
    return MEMORY.ref(2, MEMORY.ref(4, data).offset(0x0L).get() != 0x2020_4d45L ? data + 0x1bcL : data + 0x20L, SVECTOR::new);
  }

  @Method(0x801100b8L)
  public static void FUN_801100b8(final int scriptIndex, final Ref<SVECTOR> a1, final Ref<VECTOR> a2) {
    final ScriptState<?> state = scriptStatePtrArr_800bc1c0.get(scriptIndex).deref();
    final long a3 = state.innerStruct_00.getPointer(); //TODO

    if(MEMORY.ref(4, a3).get() == 0x2020_4d45L) {
      a2.set(MEMORY.ref(4, a3 + 0x14L, VECTOR::new)); //TODO
      a1.set(MEMORY.ref(2, a3 + 0x20L, SVECTOR::new)); //TODO
      return;
    }

    //LAB_801100fc
    final BtldScriptData27c a3_0 = state.innerStruct_00.derefAs(BtldScriptData27c.class);
    a2.set(a3_0._148.coord2_14.coord.transfer);
    a1.set(a3_0._148.coord2Param_64.rotate);
  }

  @Method(0x80110228L)
  public static SVECTOR FUN_80110228(final SVECTOR s2, @Nullable VECTOR a3, final VECTOR a2) {
    if(a3 == null) {
      a3 = new VECTOR();
    }

    //LAB_80110258
    final VECTOR sp0x10 = new VECTOR().set(a2).sub(a3).negate();
    final SVECTOR sp0x30 = new SVECTOR();
    sp0x30.setY((short)ratan2(sp0x10.getX(), sp0x10.getZ()));
    final long s1 = rcos(-sp0x30.getY()) * sp0x10.getZ() - rsin(-sp0x30.getY()) * sp0x10.getX();

    //LAB_80110308
    sp0x30.setX((short)ratan2(-sp0x10.getY(), (int)s1 / 0x1000));

    final MATRIX sp0x38 = new MATRIX();
    RotMatrix_80040010(sp0x30, sp0x38);
    FUN_800de544(s2, sp0x38);

    return s2;
  }

  @Method(0x8011035cL)
  public static long FUN_8011035c(final int scriptIndex1, final int scriptIndex2, final VECTOR a2) {
    final VECTOR s0 = FUN_80110030(scriptIndex1);

    if(scriptIndex2 == -0x1L) {
      a2.set(s0);
    } else {
      //LAB_801103b8
      final Ref<SVECTOR> sp0x58 = new Ref<>();
      final Ref<VECTOR> sp0x5c = new Ref<>();
      FUN_801100b8(scriptIndex2, sp0x58, sp0x5c);

      final VECTOR sp0x18 = new VECTOR().set(s0).sub(sp0x5c.get());
      final MATRIX sp0x38 = new MATRIX();
      RotMatrix_8003faf0(sp0x58.get(), sp0x38);

      final VECTOR sp0x28 = new VECTOR();
      FUN_80040ec0(sp0x38, sp0x18, sp0x28);
      a2.set(sp0x28);
    }

    //LAB_80110450
    return scriptStatePtrArr_800bc1c0.get(scriptIndex1).deref().innerStruct_00.getPointer(); //TODO
  }

  @Method(0x801105ccL)
  public static void FUN_801105cc(final VECTOR a0, final int scriptIndex, final VECTOR a2) {
    final Ref<SVECTOR> sp0x30 = new Ref<>();
    final Ref<VECTOR> sp0x34 = new Ref<>();
    FUN_801100b8(scriptIndex, sp0x30, sp0x34);

    final MATRIX sp0x10 = new MATRIX();
    RotMatrix_8003faf0(sp0x30.get(), sp0x10);

    a0
      .set(ApplyMatrixLV(sp0x10, a2))
      .add(sp0x34.get());
  }

  @Method(0x8011066cL)
  public static BttlScriptData6c FUN_8011066c(final int scriptIndex1, final int scriptIndex2, final VECTOR a2) {
    final BttlScriptData6c data = scriptStatePtrArr_800bc1c0.get(scriptIndex1).deref().innerStruct_00.derefAs(BttlScriptData6c.class);

    if(data.magic_00.get() == 0x2020_4d45L && (data._04.get() & 0x2L) != 0) {
      FUN_800e8d04(data, 0x1L);
    }

    //LAB_801106dc
    final VECTOR a0_0 = FUN_80110030(scriptIndex1);
    if(scriptIndex2 == -1) {
      a0_0.set(a2);
    } else {
      //LAB_80110718
      FUN_801105cc(a0_0, scriptIndex2, a2);
    }

    //LAB_80110720
    return data;
  }

  @Method(0x80110740L)
  public static long FUN_80110740(final BttlScriptData6c s2, final BttlScriptData6cSub34 s1) {
    s1._18.add(s1._24);
    s1._0c.add(s1._18);

    if(s1._30.get() == -1) {
      s2._10.vec_04.set(s1._0c).div(0x100);
    } else {
      //LAB_80110814
      final Ref<SVECTOR> sp0x40 = new Ref<>();
      final Ref<VECTOR> sp0x44 = new Ref<>();
      FUN_801100b8(s1._30.get(), sp0x40, sp0x44);

      final MATRIX sp0x10 = new MATRIX();
      RotMatrix_8003faf0(sp0x40.get(), sp0x10);

      final VECTOR sp0x30 = new VECTOR().set(s1._0c).div(0x100);
      s2._10.vec_04.set(ApplyMatrixLV(sp0x10, sp0x30)).add(sp0x44.get());
    }

    //LAB_801108bc
    if(s1._32.get() == -1) {
      return 0x1L;
    }

    s1._32.decr();

    if(s1._32.get() > 0) {
      //LAB_801108e0
      return 0x1L;
    }

    //LAB_801108e4
    return 0;
  }

  @Method(0x801108fcL)
  public static BttlScriptData6cSub34 FUN_801108fc(final long a0, final long a1, final int x1, final int y1, final int z1, final int x2, final int y2, final int z2) {
    final BttlScriptData6c s0 = scriptStatePtrArr_800bc1c0.get((int)a0).deref().innerStruct_00.derefAs(BttlScriptData6c.class);
    if((s0._04.get() & 0x2L) != 0) {
      FUN_800e8d04(s0, 0x1L);
    }

    //LAB_80110980
    final BttlScriptData6cSub34 s2 = FUN_800e8dd4(s0, 0x1L, 0, MEMORY.ref(4, getMethodAddress(SEffe.class, "FUN_80110740", BttlScriptData6c.class, BttlScriptData6cSub34.class), BiFunctionRef::new), 0x34L, BttlScriptData6cSub34::new);
    s2._0c.set(s0._10.vec_04.getX() << 8, s0._10.vec_04.getY() << 8, s0._10.vec_04.getZ() << 8);
    s2._30.set(-1);
    s2._32.set((short)-1);

    final int transformedX1;
    final int transformedY1;
    final int transformedZ1;
    final int transformedX2;
    final int transformedY2;
    final int transformedZ2;
    if((int)a1 != -0x1L) {
      final MATRIX rotation = new MATRIX();
      RotMatrix_8003faf0(FUN_80110074(a1), rotation);
      final VECTOR sp0x38 = new VECTOR().set(x1, y1, z1);
      final VECTOR sp0x48 = new VECTOR();
      sp0x48.set(ApplyMatrixLV(rotation, sp0x38));
      transformedX1 = sp0x48.getX();
      transformedY1 = sp0x48.getY();
      transformedZ1 = sp0x48.getZ();
      sp0x38.set(x2, y2, z2);
      sp0x48.set(ApplyMatrixLV(rotation, sp0x38));
      transformedX2 = sp0x48.getX();
      transformedY2 = sp0x48.getY();
      transformedZ2 = sp0x48.getZ();
    } else {
      transformedX1 = x1;
      transformedY1 = y1;
      transformedZ1 = z1;
      transformedX2 = x2;
      transformedY2 = y2;
      transformedZ2 = z2;
    }

    //LAB_80110a5c
    s2._18.set(transformedX1, transformedY1, transformedZ1);
    s2._24.set(transformedX2, transformedY2, transformedZ2);
    return s2;
  }

  @Method(0x801115ecL)
  public static long FUN_801115ec(final RunningScript s0) {
    final VECTOR sp0x10 = new VECTOR();
    FUN_8011035c((int)s0.params_20.get(0).deref().get(), (int)s0.params_20.get(1).deref().get(), sp0x10);
    s0.params_20.get(2).deref().set(sp0x10.getX() & 0xffff_ffffL);
    s0.params_20.get(3).deref().set(sp0x10.getY() & 0xffff_ffffL);
    s0.params_20.get(4).deref().set(sp0x10.getZ() & 0xffff_ffffL);
    return 0;
  }

  @Method(0x80111c2cL)
  public static long FUN_80111c2c(final RunningScript a0) {
    FUN_801108fc(a0.params_20.get(0).deref().get(), a0.params_20.get(1).deref().get(), (int)a0.params_20.get(2).deref().get(), (int)a0.params_20.get(3).deref().get(), (int)a0.params_20.get(4).deref().get(), (int)a0.params_20.get(5).deref().get(), (int)a0.params_20.get(6).deref().get(), (int)a0.params_20.get(7).deref().get());
    return 0;
  }

  @Method(0x80111ae4L)
  public static long FUN_80111ae4(final RunningScript a0) {
    final VECTOR sp0x10 = new VECTOR().set((int)a0.params_20.get(2).deref().get(), (int)a0.params_20.get(3).deref().get(), (int)a0.params_20.get(4).deref().get());
    FUN_8011066c((int)a0.params_20.get(0).deref().get(), (int)a0.params_20.get(1).deref().get(), sp0x10);
    return 0;
  }

  @Method(0x80112530L)
  public static long FUN_80112530(final long a0, final long a1, final SVECTOR a2) {
    final BttlScriptData6c data = scriptStatePtrArr_800bc1c0.get((int)a0).deref().innerStruct_00.derefAs(BttlScriptData6c.class);

    if(data.magic_00.get() == 0x2020_4d45L && (data._04.get() & 0x4L) != 0) {
      FUN_800e8d04(data, 0x2L);
    }

    //LAB_8011259c
    final SVECTOR s0 = FUN_80110074(a0).set(a2);
    if((int)a1 != -0x1L) {
      //LAB_801125d8
      s0.add(FUN_80110074(a1));
    }

    //LAB_8011261c
    return 0;
  }

  @Method(0x80112770L)
  public static long FUN_80112770(final RunningScript a0) {
    FUN_80112530(
      a0.params_20.get(0).deref().get(),
      a0.params_20.get(1).deref().get(),
      new SVECTOR().set(
        (short)a0.params_20.get(2).deref().get(),
        (short)a0.params_20.get(3).deref().get(),
        (short)a0.params_20.get(4).deref().get()
      )
    );

    return 0;
  }

  @Method(0x80112900L)
  public static long FUN_80112900(final RunningScript s0) {
    final SVECTOR sp0x10 = new SVECTOR();
    FUN_80110228(sp0x10, FUN_80110030((int)s0.params_20.get(0).deref().get()), FUN_80110030((int)s0.params_20.get(1).deref().get()));
    s0.params_20.get(2).deref().set(sp0x10.getX());
    s0.params_20.get(3).deref().set(sp0x10.getZ());
    s0.params_20.get(4).deref().set(sp0x10.getY());
    return 0;
  }

  @Method(0x80113624L)
  public static SVECTOR FUN_80113624(final long a0, final long a1, final SVECTOR a2) {
    ScriptState<BattleScriptDataBase> a3 = scriptStatePtrArr_800bc1c0.get((int)a0).derefAs(ScriptState.classFor(BattleScriptDataBase.class));
    BattleScriptDataBase t0 = a3.innerStruct_00.deref();

    final SVECTOR t1;
    if(t0.magic_00.get() == 0x2020_4d45L) {
      t1 = ((BttlScriptData6c)t0)._10.svec_16;
    } else {
      //LAB_80113660
      t1 = new SVECTOR().set(((BtldScriptData27c)t0)._244);
    }

    //LAB_801136a0
    if((int)a1 == -0x1L) {
      a2.set(t1);
    } else {
      //LAB_801136d0
      a3 = scriptStatePtrArr_800bc1c0.get((int)a0).derefAs(ScriptState.classFor(BattleScriptDataBase.class));
      t0 = a3.innerStruct_00.deref();

      final SVECTOR svec;
      if(t0.magic_00.get() == 0x2020_4d45L) {
        svec = ((BttlScriptData6c)t0)._10.svec_16;
      } else {
        //LAB_80113708
        svec = new SVECTOR().set(((BtldScriptData27c)t0)._244);
      }

      //LAB_80113744
      if(svec.getX() == 0) {
        svec.setX((short)1);
      }

      //LAB_80113758
      if(svec.getY() == 0) {
        svec.setY((short)1);
      }

      //LAB_8011376c
      if(svec.getZ() == 0) {
        svec.setZ((short)1);
      }

      //LAB_80113780
      a2.setX((short)((t1.getX() << 12) / svec.getX()));
      a2.setY((short)((t1.getY() << 12) / svec.getY()));
      a2.setZ((short)((t1.getZ() << 12) / svec.getZ()));
    }

    //LAB_801137ec
    return a2;
  }

  @Method(0x801137f8L)
  public static SVECTOR FUN_801137f8(final long a0, final long a1, final SVECTOR a2) {
    ScriptState<BattleScriptDataBase> a0_0 = scriptStatePtrArr_800bc1c0.get((int)a0).derefAs(ScriptState.classFor(BattleScriptDataBase.class));
    BattleScriptDataBase a3 = a0_0.innerStruct_00.deref();

    final SVECTOR t0;
    if(a3.magic_00.get() == 0x2020_4d45L) {
      t0 = ((BttlScriptData6c)a3)._10.svec_16;
    } else {
      //LAB_80113834
      t0 = new SVECTOR().set(((BtldScriptData27c)a3)._244);
    }

    //LAB_80113874
    if((int)a1 == -0x1L) {
      a2.set(t0);
    } else {
      //LAB_801138a4
      a0_0 = scriptStatePtrArr_800bc1c0.get((int)a1).derefAs(ScriptState.classFor(BattleScriptDataBase.class));
      a3 = a0_0.innerStruct_00.deref();

      final SVECTOR a0_1;
      if(a3.magic_00.get() == 0x2020_4d45L) {
        a0_1 = ((BttlScriptData6c)a3)._10.svec_16;
      } else {
        //LAB_801138dc
        a0_1 = new SVECTOR().set(((BtldScriptData27c)a3)._244);
      }

      //LAB_8011391c
      a2.set(t0).sub(a0_1);
    }

    //LAB_80113958
    return a2;
  }

  @Method(0x801139d0L)
  public static long FUN_801139d0(final RunningScript a0) {
    final long t1 = a0.params_20.get(0).deref().get();
    final long a1 = a0.params_20.get(1).deref().get();
    final short a2 = (short)a0.params_20.get(2).deref().get();
    final short a3 = (short)a0.params_20.get(3).deref().get();
    final short t0 = (short)a0.params_20.get(4).deref().get();
    short sp4;
    short sp2;
    short sp0;
    if((int)a1 == -0x1L) {
      sp0 = a2;
      sp2 = a3;
      sp4 = t0;
    } else {
      //LAB_80113a28
      final ScriptState<?> state = scriptStatePtrArr_800bc1c0.get((int)a1).deref();
      final long a1_0 = state.innerStruct_00.getPointer(); //TODO

      final SVECTOR v1;
      if(MEMORY.ref(4, a1_0).offset(0x0L).get() == 0x2020_4d45L) {
        v1 = MEMORY.ref(2, a1_0 + 0x26L, SVECTOR::new);
      } else {
        //LAB_80113a64
        v1 = new SVECTOR().set((short)MEMORY.ref(2, a1_0).offset(0x244L).get(), (short)MEMORY.ref(2, a1_0).offset(0x248L).get(), (short)MEMORY.ref(2, a1_0).offset(0x24cL).get());
      }

      //LAB_80113aa0
      //LAB_80113abc
      //LAB_80113ae0
      //LAB_80113b04
      sp0 = (short)(a2 * v1.getX() / 0x1000);
      sp2 = (short)(a3 * v1.getY() / 0x1000);
      sp4 = (short)(t0 * v1.getZ() / 0x1000);
    }

    //LAB_80113b0c
    final ScriptState<?> state = scriptStatePtrArr_800bc1c0.get((int)t1).deref();
    final long a0_0 = state.innerStruct_00.getPointer(); //TODO
    if(MEMORY.ref(4, a0_0).offset(0x0L).get() == 0x2020_4d45L) {
      MEMORY.ref(2, a0_0).offset(0x26L).setu(sp0);
      MEMORY.ref(2, a0_0).offset(0x28L).setu(sp2);
      MEMORY.ref(2, a0_0).offset(0x2aL).setu(sp4);
    } else {
      //LAB_80113b64
      MEMORY.ref(4, a0_0).offset(0x244L).setu(sp0);
      MEMORY.ref(4, a0_0).offset(0x248L).setu(sp2);
      MEMORY.ref(4, a0_0).offset(0x24cL).setu(sp4);
    }

    //LAB_80113b94
    return 0;
  }

  @Method(0x80113ba0L)
  public static long FUN_80113ba0(final BttlScriptData6c data, final BttlScriptData6cSub34 sub) {
    sub._18.add(sub._24);
    sub._0c.add(sub._18);
    data._10.svec_16.set(sub._0c);

    if(sub._32.get() == -0x1L) {
      return 0x1L;
    }

    sub._32.decr();
    if(sub._32.get() > 0) {
      //LAB_80113c60
      return 0x1L;
    }

    //LAB_80113c64
    return 0;
  }

  @Method(0x80113db8L)
  public static long FUN_80113db8(long a0, final RunningScript a1) {
    final long s7 = a1.params_20.get(0).deref().get();
    final long s3 = a1.params_20.get(1).deref().get();
    final long s2 = a1.params_20.get(2).deref().get();
    final long s4 = a1.params_20.get(3).deref().get();
    final long s5 = a1.params_20.get(4).deref().get();
    final long s6 = a1.params_20.get(5).deref().get();

    if((int)s2 >= 0) {
      final BttlScriptData6c s1 = scriptStatePtrArr_800bc1c0.get((int)s7).deref().innerStruct_00.derefAs(BttlScriptData6c.class);

      if((s1._04.get() & 0x8L) != 0) {
        FUN_800e8d04(s1, 0x3L);
      }

      //LAB_80113e70
      final BttlScriptData6cSub34 s0 = FUN_800e8dd4(s1, 0x3L, 0, MEMORY.ref(4, getMethodAddress(SEffe.class, "FUN_80113ba0", BttlScriptData6c.class, BttlScriptData6cSub34.class), BiFunctionRef::new), 0x34L, BttlScriptData6cSub34::new);

      final VECTOR sp0x18 = new VECTOR().set((int)s4, (int)s5, (int)s6);
      if(a0 == 0) {
        //LAB_80113eac
        final SVECTOR sp0x28 = new SVECTOR();
        FUN_801137f8(s7, s3, sp0x28);
        sp0x18.sub(sp0x28);
      } else if(a0 == 0x1L) {
        //LAB_80113ee8
        if(s3 != -0x1L) {
          //LAB_80113f04
          final SVECTOR sp0x28 = new SVECTOR();
          FUN_80113624(s3, -0x1L, sp0x28);

          //LAB_80113f2c
          //LAB_80113f50
          //LAB_80113f74
          sp0x18.mul(sp0x28).div(0x1000);
        }

        //LAB_80113f7c
        //LAB_80113fb4
        sp0x18.sub(s1._10.svec_16);
      } else {
        throw new RuntimeException("Invalid a0 " + a0);
      }

      //LAB_80113fc0
      s0._30.set(-1);
      s0._32.set((short)s2);
      s0._0c.set(s1._10.svec_16);
      s0._18.set(sp0x18).div((int)s2);
      s0._24.set(0, 0, 0);
    }

    //LAB_8011403c
    return 0;
  }

  @Method(0x80114094L)
  public static long FUN_80114094(final RunningScript a0) {
    return FUN_80113db8(1, a0);
  }

  @Method(0x80114598L)
  public static long FUN_80114598(final RunningScript a0) {
    long a1 = scriptStatePtrArr_800bc1c0.get((int)a0.params_20.get(0).deref().get()).deref().innerStruct_00.getPointer(); //TODO

    final SVECTOR a3;
    if(MEMORY.ref(4, a1).offset(0x0L).get() != 0x2020_4d45L) {
      a3 = new SVECTOR().set(_800fb94c);
    } else {
      a3 = MEMORY.ref(2, a1 + 0x2cL, SVECTOR::new);
    }

    //LAB_80114614
    if((int)a0.params_20.get(1).deref().get() == -0x1L) {
      a3.setX((short)a0.params_20.get(2).deref().get());
      a3.setY((short)a0.params_20.get(3).deref().get());
      a3.setZ((short)a0.params_20.get(4).deref().get());
    } else {
      //LAB_80114668
      a1 = scriptStatePtrArr_800bc1c0.get((int)a0.params_20.get(1).deref().get()).deref().innerStruct_00.getPointer(); //TODO

      final SVECTOR a2;
      if(MEMORY.ref(4, a1).offset(0x0L).get() != 0x2020_4d45L) {
        a2 = _800fb94c;
      } else {
        a2 = MEMORY.ref(2, a1 + 0x2cL, SVECTOR::new);
      }

      //LAB_8011469c
      a3.setX((short)(a0.params_20.get(2).deref().get() + a2.getX()));
      a3.setY((short)(a0.params_20.get(3).deref().get() + a2.getY()));
      a3.setZ((short)(a0.params_20.get(4).deref().get() + a2.getZ()));
    }

    //LAB_801146f0
    return 0;
  }

  @Method(0x80114e60L)
  public static long FUN_80114e60(final RunningScript a0) {
    final long v0 = scriptStatePtrArr_800bc1c0.get((int)a0.params_20.get(0).deref().get()).deref().innerStruct_00.getPointer(); //TODO
    MEMORY.ref(4, v0).offset(0x34L).offset(a0.params_20.get(1).deref().get() * 0x4L).setu(a0.params_20.get(2).deref().get());
    return 0;
  }

  @Method(0x80115288L)
  public static long FUN_80115288(final BttlScriptData6c a0, final BttlScriptData6cSub1c a1) {
    MEMORY.ref(2, a1.getAddress()).offset(0x1aL).subu(0x1L); //TODO

    //LAB_801152a8
    return MEMORY.ref(2, a1.getAddress()).offset(0x1aL).getSigned() > 0 ? 0x1L : 0x2L; //TODO
  }

  @Method(0x801152b0L)
  public static long FUN_801152b0(final RunningScript a0) {
    final BttlScriptData6cSub1c v0 = FUN_800e8dd4(scriptStatePtrArr_800bc1c0.get((int)a0.params_20.get(0).deref().get()).deref().innerStruct_00.derefAs(BttlScriptData6c.class), 0, 0, MEMORY.ref(4, getMethodAddress(SEffe.class, "FUN_80115288", BttlScriptData6c.class, BttlScriptData6cSub1c.class), BiFunctionRef::new), 0x1cL, BttlScriptData6cSub1c::new);
    MEMORY.ref(2, v0.getAddress()).offset(0x1aL).setu(a0.params_20.get(1).deref().get()); //TODO
    return 0;
  }

  @Method(0x80115690L)
  public static long FUN_80115690(final RunningScript a0) {
    final long s0 = a0.params_20.get(0).deref().get();
    loadScriptFile(s0, a0.scriptState_04.deref().scriptPtr_14.deref(), 0, "S_EFFE Script", 0); //TODO unknown size
    scriptStatePtrArr_800bc1c0.get((int)s0).deref().commandPtr_18.set(a0.params_20.get(1).deref());
    return 0;
  }

  @Method(0x801156f8L)
  public static long FUN_801156f8(final RunningScript a0) {
    final long v0 = scriptStatePtrArr_800bc1c0.get((int)a0.params_20.get(0).deref().get()).deref().innerStruct_00.getPointer(); //TODO
    MEMORY.ref(1, v0).offset(0xcL).setu(a0.params_20.get(1).deref().get());
    MEMORY.ref(1, v0).offset(0xdL).setu(a0.params_20.get(2).deref().get());
    return 0;
  }

  @Method(0x80115cacL)
  public static void FUN_80115cac(long a0) {
    assert false;
  }

  @Method(0x8011826cL)
  public static void FUN_8011826c(final int index, final ScriptState<BttlScriptData6c> state, final BttlScriptData6c data) {
    final long s1 = data._44.getPointer(); //TODO

    if((int)data._10._00.get() >= 0) {
      final MATRIX sp0x10 = new MATRIX();
      FUN_800e8594(sp0x10, data);
      if((data._10._00.get() & 0x4000_0000L) != 0) {
        _1f8003ec.setu((data._10._00.get() >>> 23) & 0x60L);
      } else {
        //LAB_801182bc
        _1f8003ec.setu(MEMORY.ref(2, s1).offset(0x10L).get());
      }

      //LAB_801182c8
      _1f8003e8.setu(data._10._22.get());
      if((data._10._00.get() & 0x40L) == 0) {
        FUN_800e61e4(data._10.svec_1c.getX() << 5, data._10.svec_1c.getY() << 5, data._10.svec_1c.getZ() << 5);
      } else {
        //LAB_80118304
        FUN_800e60e0(0x1000L, 0x1000L, 0x1000L);
      }

      //LAB_80118314
      if(data._0c.get() < -0x2L) {
        if(data._0c.get() == -0x4L) {
          sp0x10.transfer.setZ((int)_1f8003f8.get());
        }

        //LAB_8011833c
        GsSetLightMatrix(sp0x10);
        setRotTransMatrix(sp0x10);

        FUN_800e3e6c(new long[] {data._10._00.get(), 0, MEMORY.ref(4, s1).offset(0x8L).get()});
      } else {
        //LAB_80118370
        FUN_800de3f4(MEMORY.ref(4, s1).offset(0x8L).get(), data._10, sp0x10);
      }

      //LAB_80118380
      if((data._10._00.get() & 0x40L) == 0) {
        FUN_800e62a8();
      } else {
        //LAB_801183a4
        FUN_800e6170();
      }
    }

    //LAB_801183ac
  }

  @Method(0x801183c0L)
  public static long FUN_801183c0(final RunningScript s3) {
    final long s1 = s3.params_20.get(1).deref().get();
    final long s4 = FUN_800e80c4(s3.scriptStateIndex_00.get(), 0x14L, null, MEMORY.ref(4, getMethodAddress(SEffe.class, "FUN_8011826c", int.class, ScriptState.classFor(BttlScriptData6c.class), BttlScriptData6c.class), TriConsumerRef::new), null, BttlScriptData6cSub14::new);
    final BttlScriptData6c s2 = scriptStatePtrArr_800bc1c0.get((int)s4).deref().innerStruct_00.derefAs(BttlScriptData6c.class);
    s2._04.set(0x300_0000L);
    final long s0 = s2._44.getPointer(); //TODO
    MEMORY.ref(4, s0).offset(0x0L).setu(s1 | 0x300_0000L);
    if((s1 & 0xf_ff00L) == 0xf_ff00L) {
      MEMORY.ref(2, s0).offset(0x10L).setu(0x20L);
      MEMORY.ref(4, s0).offset(0x4L).setu(0);
      MEMORY.ref(4, s0).offset(0x8L).setu(_800c693c.deref(4).offset((s1 & 0xffL) * 0x4L).offset(0x2f8L).get());
    } else {
      //LAB_8011847c
      long v0 = FUN_800eac58(s1 | 0x300_0000L);
      MEMORY.ref(4, s0).offset(0x4L).setu(v0);
      v0 = v0 + MEMORY.ref(4, v0).offset(0xcL).get();
      MEMORY.ref(4, s0).offset(0x8L).setu(v0 + 0x18L);
      MEMORY.ref(2, s0).offset(0x10L).setu((MEMORY.ref(4, v0).offset(0xcL).get() & 0xffff_0000L) >>> 11);
    }

    //LAB_801184ac
    s2._10._00.set(0x1400_0000L);
    s3.params_20.get(0).deref().set(s4);
    return 0;
  }

  @Method(0x801186f8L)
  public static void FUN_801186f8(final long a0, final long a1) {
    MEMORY.ref(4, a0).offset(0x0L).setu(a1 | 0x300_0000L);
    if((a1 & 0xf_ff00L) == 0xf_ff00L) {
      MEMORY.ref(2, a0).offset(0x10L).setu(0x20L);
      MEMORY.ref(4, a0).offset(0x4L).setu(0);
      MEMORY.ref(4, a0).offset(0x8L).setu(_800c693c.deref(4).offset((a1 & 0xffL) * 0x4L).offset(0x2f8L).get());
    } else {
      //LAB_80118750
      long v0 = FUN_800eac58(a1 | 0x300_0000L);
      MEMORY.ref(4, a0).offset(0x4L).setu(v0);
      v0 = v0 + MEMORY.ref(4, v0).offset(0xcL).get();
      MEMORY.ref(4, a0).offset(0x8L).setu(v0 + 0x18L);
      MEMORY.ref(2, a0).offset(0x10L).setu((MEMORY.ref(4, v0).offset(0xcL).get() & 0xffff_0000L) >>> 11);
    }

    //LAB_80118780
  }

  @Method(0x80118e98L)
  public static void FUN_80118e98(final int index, final ScriptState<BttlScriptData6c> state, final BttlScriptData6c data) {
    long v0;
    long v1;
    long a2;
    long a3;
    long t0;
    long t1;
    long t5;
    long s1;
    long s2;
    long s3;
    long s4;
    long s5;
    long s6;
    long lo;
    final VECTOR sp0x84 = new VECTOR();
    final VECTOR sp0x90 = new VECTOR();
    final VECTOR sp0x9c = new VECTOR();
    long spb0;
    long spb4;
    long spb8;

    final BttlScriptData6c fp = scriptStatePtrArr_800bc1c0.get(index).deref().innerStruct_00.derefAs(BttlScriptData6c.class);
    final BttlScriptData6cSub30 s0 = fp._44.derefAs(BttlScriptData6cSub30.class);
    if((int)fp._10._00.get() >= 0) {
      final MATRIX sp0x10 = new MATRIX();
      FUN_800e8594(sp0x10, fp);

      v1 = s0.scriptIndex_04.get() & 0xff00_0000L;
      if(v1 == 0x300_0000L) {
        //LAB_80118f38
        if((fp._10._00.get() & 0x4000_0000L) != 0) {
          _1f8003ec.setu(fp._10._00.get() >>> 23 & 0x60L);
        } else {
          //LAB_80118f5c
          _1f8003ec.setu(s0._2c.get());
        }

        //LAB_80118f68
        _1f8003e8.setu(fp._10._22.get());

        if((fp._10._00.get() & 0x40L) == 0) {
          FUN_800e61e4(fp._10.svec_1c.getX() << 5, fp._10.svec_1c.getY() << 5, fp._10.svec_1c.getZ() << 5);
        }

        //LAB_80118f9c
        FUN_800de3f4(s0._24.get(), fp._10, sp0x10);
      } else if(v1 == 0x400_0000L) {
        FUN_800e9428(s0.getAddress() + 0x20L, fp._10, sp0x10); //TODO
      }

      //LAB_80118fac
      if(s0._08.get() != 0) {
        final Memory.TemporaryReservation sp0x50tmp = MEMORY.temp(0x34);
        final BttlScriptData6cInner sp0x50 = sp0x50tmp.get().cast(BttlScriptData6cInner::new);

        //LAB_80118fc4
        memcpy(sp0x50.getAddress(), fp._10.getAddress(), 0x34);

        t0 = s0._08.get();
        v0 = s0._0c.get() + 0x1L;
        lo = (long)(int)t0 * (int)v0 & 0xffff_ffffL;
        a2 = lo;
        if((s0.scriptIndex_00.get() & 0x4L) != 0) {
          v0 = s0._10.get() - 0x1000L;
          lo = sp0x50.svec_1c.getX() * (int)v0 & 0xffff_ffffL;
          v1 = lo;
          lo = (int)v1 / (int)a2;
          t1 = lo;
          lo = sp0x50.svec_1c.getY() * (int)v0 & 0xffff_ffffL;
          v1 = lo;
          sp0x84.setX((int)t1);
          lo = (int)v1 / (int)a2;
          t1 = lo;
          lo = sp0x50.svec_1c.getZ() * (int)v0 & 0xffff_ffffL;
          t5 = lo;
          sp0x50.vec_28.setX(sp0x50.svec_1c.getX() << 12);
          sp0x50.vec_28.setY(sp0x50.svec_1c.getY() << 12);
          sp0x50.vec_28.setZ(sp0x50.svec_1c.getZ() << 12);
          sp0x84.setY((int)t1);
          lo = (int)t5 / (int)a2;
          t1 = lo;
          sp0x84.setZ((int)t1);
        }

        //LAB_801190a8
        if((s0.scriptIndex_00.get() & 0x8L) != 0) {
          v0 = s0._10.get() - 0x1000L;
          lo = sp0x50.svec_16.getX() * (int)v0 & 0xffff_ffffL;
          v1 = lo;
          lo = (int)v1 / (int)a2;
          t1 = lo;
          lo = sp0x50.svec_16.getY() * (int)v0 & 0xffff_ffffL;
          v1 = lo;
          sp0x9c.setX((int)t1);
          lo = (int)v1 / (int)a2;
          t1 = lo;
          lo = sp0x50.svec_16.getZ() * (int)v0 & 0xffff_ffffL;
          sp0x90.setX(sp0x50.svec_16.getX() << 12);
          sp0x90.setY(sp0x50.svec_16.getY() << 12);
          a3 = lo;
          sp0x90.setZ(sp0x50.svec_16.getZ() << 12);
          sp0x9c.setY((int)t1);
          lo = (int)a3 / (int)a2;
          t1 = lo;
          sp0x9c.setZ((int)t1);
        }

        //LAB_80119130
        //LAB_8011914c
        for(s6 = 1; s6 < s0._08.get() && s6 < s0._14.get(); s6++) {
          final VECTOR a1 = s0._18.deref().get((int)((s0._14.get() - s6 - 0x1L) % s0._08.get()));

          v1 = s0._0c.get() + 0x1L;
          spb0 = (a1.getX() - sp0x10.transfer.getX() << 12) / (int)v1;
          spb4 = (a1.getY() - sp0x10.transfer.getY() << 12) / (int)v1;
          spb8 = (a1.getZ() - sp0x10.transfer.getZ() << 12) / (int)v1;

          s4 = sp0x10.transfer.getX() << 12;
          s3 = sp0x10.transfer.getY() << 12;
          s2 = sp0x10.transfer.getZ() << 12;

          s5 = s0.scriptIndex_04.get() & 0xff00_0000L;

          //LAB_80119204
          for(s1 = s0._0c.get(); s1 >= 0; s1--) {
            if((s0.scriptIndex_00.get() & 0x4L) != 0) {
              sp0x50.vec_28.add(sp0x84);
              //LAB_80119254
              //LAB_80119270
              //LAB_8011928c
              sp0x50.svec_1c.setX((short)(sp0x50.vec_28.getX() / 0x1000));
              sp0x50.svec_1c.setY((short)(sp0x50.vec_28.getY() / 0x1000));
              sp0x50.svec_1c.setZ((short)(sp0x50.vec_28.getZ() / 0x1000));
            }

            //LAB_80119294
            if((s0.scriptIndex_00.get() & 0x8L) != 0) {
              sp0x90.add(sp0x9c);

              //LAB_801192e4
              //LAB_80119300
              //LAB_8011931c
              sp0x50.svec_16.setX((short)(sp0x90.getX() / 0x1000));
              sp0x50.svec_16.setY((short)(sp0x90.getY() / 0x1000));
              sp0x50.svec_16.setZ((short)(sp0x90.getZ() / 0x1000));
            }

            //LAB_80119324
            s4 = s4 + spb0;
            s3 = s3 + spb4;
            s2 = s2 + spb8;

            //LAB_80119348
            //LAB_80119360
            //LAB_80119378
            final MATRIX sp0x30 = new MATRIX().set(sp0x10);
            sp0x30.transfer.set((int)(s4 / 0x1000), (int)(s3 / 0x1000), (int)(s2 / 0x1000));

            ScaleVectorL_SVEC(sp0x30, sp0x50.svec_16);
            if(s5 == 0x300_0000L) {
              //LAB_801193f0
              FUN_800de3f4(s0._24.get(), sp0x50, sp0x30);
            } else if(s5 == 0x400_0000L) {
              FUN_800e9428(s0.getAddress() + 0x20L, sp0x50, sp0x30); //TODO
            }

            //LAB_80119400
            //LAB_80119404
          }

          //LAB_8011940c
        }

        sp0x50tmp.release();

        //LAB_80119420
        if((s0.scriptIndex_04.get() & 0xff00_0000L) == 0x300_0000L && (fp._10._00.get() & 0x40L) == 0) {
          FUN_800e62a8();
        }
      }
    }

    //LAB_80119454
  }

  @Method(0x80119484L)
  public static long FUN_80119484(final RunningScript a0) {
    long s4 = a0.params_20.get(1).deref().get();
    long s2 = a0.params_20.get(2).deref().get();
    long s6 = a0.params_20.get(3).deref().get();
    long s0 = a0.params_20.get(4).deref().get();
    long s1 = a0.params_20.get(5).deref().get();

    long fp = FUN_800e80c4(
      a0.scriptStateIndex_00.get(),
      0x30L,
      MEMORY.ref(4, getMethodAddress(SEffe.class, "FUN_801196bc", int.class, ScriptState.classFor(BttlScriptData6c.class), BttlScriptData6c.class), TriConsumerRef::new),
      MEMORY.ref(4, getMethodAddress(SEffe.class, "FUN_80118e98", int.class, ScriptState.classFor(BttlScriptData6c.class), BttlScriptData6c.class), TriConsumerRef::new),
      MEMORY.ref(4, getMethodAddress(SEffe.class, "FUN_80119788", int.class, ScriptState.classFor(BttlScriptData6c.class), BttlScriptData6c.class), TriConsumerRef::new),
      BttlScriptData6cSub30::new
    );

    ScriptState<BttlScriptData6c> v0 = scriptStatePtrArr_800bc1c0.get((int)fp).derefAs(ScriptState.classFor(BttlScriptData6c.class));
    final BttlScriptData6c data = v0.innerStruct_00.deref();
    strcpy(data._5c, _800fb954.get());

    final BttlScriptData6cSub30 s3 = data._44.derefAs(BttlScriptData6cSub30.class);
    s3.scriptIndex_00.set(s2);
    s3.scriptIndex_04.set(s4);
    s3._08.set(s6);
    s3._0c.set(s0);
    s3._10.set(s1);
    s3._14.set(0);

    if(s6 != 0) {
      s3._18.setPointer(addToLinkedListHead(s6 * 0x10L));
    } else {
      //LAB_80119568
      s3._18.clear();
    }

    //LAB_8011956c
    final long v1 = s4 & 0xff00_0000L;
    if(v1 == 0x400_0000L) {
      //LAB_80119640
      FUN_800e95f0(s3.getAddress() + 0x1cL, s4); //TODO
      data._10._00.or(0x5000_0000L).and(0xfbff_ffffL);
    } else if(v1 == 0x300_0000L) {
      //LAB_80119668
      FUN_801186f8(s3.getAddress() + 0x1cL, s4); //TODO
      data._10._00.set(0x1400_0000L);
    } else if(v1 == 0) {
      //LAB_801195a8
      final BttlScriptData6cSubBase1 v1_0 = scriptStatePtrArr_800bc1c0.get((int)s4).deref().innerStruct_00.derefAs(BttlScriptData6c.class)._44.deref();
      s4 = v1_0.scriptIndex_00.get();
      s3.scriptIndex_04.set(s4);

      final long a1 = s4 & 0xff00_0000L;
      if(a1 == 0x300_0000L) {
        //LAB_8011960c
        //TODO
        MEMORY.ref(4, s3.getAddress()).offset(0x1cL).setu(MEMORY.ref(4, v1_0.getAddress()).offset(0x0L).get());
        MEMORY.ref(4, s3.getAddress()).offset(0x20L).setu(MEMORY.ref(4, v1_0.getAddress()).offset(0x4L).get());
        MEMORY.ref(4, s3.getAddress()).offset(0x24L).setu(MEMORY.ref(4, v1_0.getAddress()).offset(0x8L).get());
        MEMORY.ref(4, s3.getAddress()).offset(0x28L).setu(MEMORY.ref(4, v1_0.getAddress()).offset(0xcL).get());
        MEMORY.ref(4, s3.getAddress()).offset(0x2cL).setu(MEMORY.ref(4, v1_0.getAddress()).offset(0x10L).get());
      } else if(a1 == 0x400_0000L) {
        //TODO
        MEMORY.ref(4, s3.getAddress()).offset(0x1cL).setu(MEMORY.ref(4, v1_0.getAddress()).offset(0x0L).get());
        MEMORY.ref(4, s3.getAddress()).offset(0x20L).setu(MEMORY.ref(4, v1_0.getAddress()).offset(0x4L).get());
        MEMORY.ref(4, s3.getAddress()).offset(0x24L).setu(MEMORY.ref(4, v1_0.getAddress()).offset(0x8L).get());
      }
    }

    //LAB_8011967c
    a0.params_20.get(0).deref().set(fp);
    return 0;
  }

  @Method(0x801196bcL)
  public static void FUN_801196bc(final int index, final ScriptState<BttlScriptData6c> state, final BttlScriptData6c data) {
    final BttlScriptData6c a1 = scriptStatePtrArr_800bc1c0.get(index).deref().innerStruct_00.derefAs(BttlScriptData6c.class);
    final BttlScriptData6cSub30 s0 = a1._44.derefAs(BttlScriptData6cSub30.class);

    if(s0._08.get() != 0) {
      final MATRIX sp0x10 = new MATRIX();
      FUN_800e8594(sp0x10, a1);
      s0._18.deref().get((int)(s0._14.get() % s0._08.get())).set(sp0x10.transfer);
      s0._14.incr();
    }

    //LAB_80119778
  }

  @Method(0x80119788L)
  public static void FUN_80119788(final int index, final ScriptState<BttlScriptData6c> state, final BttlScriptData6c data6c) {
    assert false;
  }
}